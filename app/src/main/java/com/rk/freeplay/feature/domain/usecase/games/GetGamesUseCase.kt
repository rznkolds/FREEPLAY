package com.rk.freeplay.feature.domain.usecase.games

import com.rk.freeplay.common.Resource
import com.rk.freeplay.feature.domain.model.GameUI
import kotlinx.coroutines.flow.Flow

interface GetGamesUseCase {

    operator fun invoke(): Flow<Resource<List<GameUI>>>
}