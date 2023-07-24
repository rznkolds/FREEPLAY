package com.rk.freeplay.feature.data.repository

import com.rk.freeplay.feature.data.api.GameService
import com.rk.freeplay.feature.data.mapper.convertGameDetailUI
import com.rk.freeplay.feature.data.mapper.convertGameUI
import com.rk.freeplay.feature.domain.model.GameUI
import com.rk.freeplay.feature.domain.repository.GetGameRepository
import javax.inject.Inject

class GetGameRepositoryImpl @Inject constructor(
    private val api: GameService
) : GetGameRepository {

    override suspend fun getGames(): List<GameUI> = api.getGames().map { it.convertGameUI() }

    override suspend fun getGameDetail(id: Int) = api.getGameFromID(id).convertGameDetailUI()
}