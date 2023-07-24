package com.rk.freeplay.di

import com.rk.freeplay.feature.domain.usecase.details.GetGameDetailUseCase
import com.rk.freeplay.feature.domain.usecase.details.GetGameDetailUseCaseImpl
import com.rk.freeplay.feature.domain.usecase.games.GetGamesUseCase
import com.rk.freeplay.feature.domain.usecase.games.GetGamesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindAddStepUseCase(usecase: GetGamesUseCaseImpl) : GetGamesUseCase

    @Binds
    @Singleton
    abstract fun bindGetStepUseCase(usecase: GetGameDetailUseCaseImpl): GetGameDetailUseCase
}