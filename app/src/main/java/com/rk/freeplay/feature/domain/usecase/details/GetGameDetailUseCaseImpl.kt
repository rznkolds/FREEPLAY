package com.rk.freeplay.feature.domain.usecase.details

import com.rk.freeplay.common.Resource
import com.rk.freeplay.feature.domain.model.GameDetailUI
import com.rk.freeplay.feature.domain.repository.GetGameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class GetGameDetailUseCaseImpl @Inject constructor(
    private val repo: GetGameRepository
) : GetGameDetailUseCase {

    override operator fun invoke(id:Int): Flow<Resource<GameDetailUI>> = flow {

        try {
            emit(Resource.Loading)

            emit(Resource.Success(data = repo.getGameDetail(id)))

        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
}