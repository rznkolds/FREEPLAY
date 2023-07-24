package com.rk.freeplay.feature.data.dto

import com.google.gson.annotations.SerializedName

data class GameDetail(
    val id: Int,
    val title: String,
    val developer: String,
    val platform: String,
    val publisher: String,
    val genre: String,
    val thumbnail: String,
    val status: String,
    @SerializedName("game_url")
    val game: String,
    @SerializedName("release_date")
    val release: String,
    @SerializedName("short_description")
    val description: String,
    @SerializedName("freetogame_profile_url")
    val profile: String,
    @SerializedName("minimum_system_requirements")
    val requirement: Requirements,
    @SerializedName("screenshots")
    val pictures: ArrayList<Pictures>
)
