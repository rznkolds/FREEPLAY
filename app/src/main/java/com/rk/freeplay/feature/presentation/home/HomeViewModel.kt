package com.rk.freeplay.feature.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.freeplay.common.Resource
import com.rk.freeplay.feature.domain.usecase.games.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
) : ViewModel() {

    init {
        getGames()
    }

    private val _state = mutableStateOf(HomeUIState())
    val state: State<HomeUIState> = _state

    private fun getGames() {

        getGamesUseCase().onEach { v ->

            when (v) {
                is Resource.Loading -> {
                    _state.value = _state.value.copy(loading = "")
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(error = "")
                }

                is Resource.Success -> v.data.let {
                    _state.value = _state.value.copy(list = it)
                }
            }

        }.launchIn(viewModelScope)
    }
}