package com.rk.freeplay.di

import com.rk.freeplay.feature.data.repository.GetGameRepositoryImpl
import com.rk.freeplay.feature.domain.repository.GetGameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStepRepository(repo: GetGameRepositoryImpl): GetGameRepository
}