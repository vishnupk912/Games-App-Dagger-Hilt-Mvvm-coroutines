package com.vishnu.dagger.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


//OpenActivity
fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun <T> result(call: suspend () -> Response<T>): Flow<ApiResponse<T?>> = flow {
    emit(ApiResponse.Loading)

    try {
        val c= call()
        c.let {
            if(c.isSuccessful){
                emit(ApiResponse.Success(it.body()))
            }else{
                c.errorBody()?.let {
                    it.close()
                    emit(ApiResponse.Failure(it.string()))
                }
            }
        }
    }catch (t:Throwable){
        t.printStackTrace()
    }
}