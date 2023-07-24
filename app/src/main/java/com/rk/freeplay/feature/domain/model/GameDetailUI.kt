package com.rk.freeplay.feature.domain.model

import com.rk.freeplay.feature.data.dto.Pictures
import com.rk.freeplay.feature.data.dto.Requirements

data class GameDetailUI(
    val id: Int,
    val description: String?,
    val profile: String?,
    val game: String?,
    val genre: String?,
    val requirements: Requirements?,
    val platform: String?,
    val publisher: String?,
    val release: String?,
    val pictures: List<Pictures>?,
    val thumbnail: String?,
    val title: String?
)
