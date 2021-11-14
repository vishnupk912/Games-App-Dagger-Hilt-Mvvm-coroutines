package com.vishnu.dagger.ui.home

import androidx.lifecycle.ViewModel
import com.vishnu.dagger.model.GamesModel
import com.vishnu.dagger.network.repository.GamesRepo
import com.vishnu.dagger.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: GamesRepo) : ViewModel() {


       val  data = repo.getGame()





}