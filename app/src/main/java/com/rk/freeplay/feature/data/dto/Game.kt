package com.rk.freeplay.feature.data.dto

import com.google.gson.annotations.SerializedName

data class Game(
    val id: Int,
    val title:String,
    val developer: String,
    val platform: String,
    val publisher: String,
    val genre: String,
    val thumbnail: String,
    @SerializedName("game_url")
    val game: String,
    @SerializedName("release_date")
    val release: String,
    @SerializedName("short_description")
    val description: String,
    @SerializedName("freetogame_profile_url")
    val profile: String
)
