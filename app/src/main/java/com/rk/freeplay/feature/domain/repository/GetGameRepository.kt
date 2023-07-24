package com.rk.freeplay.feature.domain.repository

import com.rk.freeplay.feature.domain.model.GameDetailUI
import com.rk.freeplay.feature.domain.model.GameUI

interface GetGameRepository {

    suspend fun getGames(): List<GameUI>

    suspend fun getGameDetail(id: Int): GameDetailUI
}