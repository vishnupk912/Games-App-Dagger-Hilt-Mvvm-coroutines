package com.vishnu.dagger.network

import com.vishnu.dagger.model.GamesDetailsModel
import com.vishnu.dagger.model.GamesModel
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("games")
    suspend fun getGame():Response<GamesModel>

    @FormUrlEncoded
    @POST("search")
    suspend fun search(@Field("name") name :String):Response<GamesModel>

    @GET("games/{id}")
    suspend fun gameDetails(@Path("id") id :Int):Response<GamesDetailsModel>


}