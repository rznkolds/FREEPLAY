package com.rk.freeplay.feature.domain.model

data class GameUI(
    val id: Int,
    val platform: String,
    val release: String,
    val description: String,
    val genre: String,
    val thumbnail: String,
    val title: String,
    val game: String,
)
