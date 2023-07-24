package com.rk.freeplay.feature.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.freeplay.common.Resource
import com.rk.freeplay.feature.domain.usecase.details.GetGameDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getGameDetailUseCase: GetGameDetailUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DetailUIState())
    val state: State<DetailUIState> = _state

    fun getGameDetail(id: Int) {

        getGameDetailUseCase(id).onEach { v ->

            when (v) {
                is Resource.Loading -> {
                    _state.value = _state.value.copy(loading = "")
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(error = "")
                }

                is Resource.Success -> v.data.let {
                    _state.value = _state.value.copy(details = it)
                }
            }

        }.launchIn(viewModelScope)
    }
}