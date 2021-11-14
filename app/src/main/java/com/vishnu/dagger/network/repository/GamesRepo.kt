package com.vishnu.dagger.network.repository

import com.vishnu.dagger.network.ApiInterface
import com.vishnu.dagger.utils.result
import javax.inject.Inject


class GamesRepo @Inject constructor(private val api: ApiInterface) {


    fun getGame() = result {
        api.getGame()
    }






}