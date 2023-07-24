package com.rk.freeplay.feature.data.api

import com.rk.freeplay.feature.data.dto.Game
import com.rk.freeplay.feature.data.dto.GameDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {

    @GET("api/games")
    suspend fun getGames(): List<Game>

    @GET("api/game")
    suspend fun getGameFromID(@Query("id") id: Int): GameDetail
}