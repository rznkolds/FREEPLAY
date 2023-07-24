package com.rk.freeplay.feature.domain.usecase.games

import com.rk.freeplay.common.Resource
import com.rk.freeplay.feature.domain.model.GameUI
import com.rk.freeplay.feature.domain.repository.GetGameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class GetGamesUseCaseImpl @Inject constructor(
    private val repo: GetGameRepository
) : GetGamesUseCase {

    override operator fun invoke(): Flow<Resource<List<GameUI>>> = flow {

        try {
            emit(Resource.Loading)

            emit(Resource.Success(data = repo.getGames()))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
}