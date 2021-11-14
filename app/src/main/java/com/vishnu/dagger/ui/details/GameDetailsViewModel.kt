package com.vishnu.dagger.ui.details

import androidx.lifecycle.ViewModel
import com.vishnu.dagger.model.GamesDetailsModel
import com.vishnu.dagger.network.repository.GameDetailsRepo
import com.vishnu.dagger.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class GameDetailsViewModel @Inject constructor(val repo: GameDetailsRepo) : ViewModel() {
    var _details: Flow<ApiResponse<GamesDetailsModel?>> = MutableStateFlow(ApiResponse.Empty)

    fun details(id: Int) {
        _details = repo.getGameDetails(id)

    }

}