package com.rk.freeplay.feature.domain.usecase.details

import com.rk.freeplay.common.Resource
import com.rk.freeplay.feature.domain.model.GameDetailUI
import kotlinx.coroutines.flow.Flow

interface GetGameDetailUseCase {

    operator fun invoke(id:Int): Flow<Resource<GameDetailUI>>
}