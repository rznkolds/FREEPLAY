package com.rk.freeplay.feature.presentation.detail

import com.rk.freeplay.feature.domain.model.GameDetailUI

data class DetailUIState(
    val details: GameDetailUI? = null,
    val loading: String? = null,
    val error: String? = null,
)