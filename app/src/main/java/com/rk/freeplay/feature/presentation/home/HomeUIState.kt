package com.rk.freeplay.feature.presentation.home

import com.rk.freeplay.feature.domain.model.GameUI

data class HomeUIState(
    val list: List<GameUI>? = null,
    val loading: String? = null,
    val error: String? = null,
)