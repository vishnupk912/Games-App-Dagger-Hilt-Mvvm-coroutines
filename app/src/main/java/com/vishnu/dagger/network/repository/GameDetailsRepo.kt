package com.vishnu.dagger.network.repository

import com.vishnu.dagger.network.ApiInterface
import javax.inject.Inject
import com.vishnu.dagger.utils.result


class GameDetailsRepo @Inject constructor(private val api: ApiInterface) {

    fun getGameDetails(id:Int) = result {
        api.gameDetails(id)
    }

}