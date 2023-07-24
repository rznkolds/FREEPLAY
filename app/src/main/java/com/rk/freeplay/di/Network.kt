package com.rk.freeplay.di

import com.google.gson.GsonBuilder
import com.rk.freeplay.common.Constant.BASE_URL
import com.rk.freeplay.feature.data.api.GameService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Provides
    @Singleton
    fun provideInstance(url: String): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(url)
            .build()
    }

    @Provides
    @Singleton
    fun provideGameService(): GameService = provideInstance(BASE_URL).create(GameService::class.java)
}