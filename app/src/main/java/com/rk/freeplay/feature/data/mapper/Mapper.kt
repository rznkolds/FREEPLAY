package com.rk.freeplay.feature.data.mapper

import com.rk.freeplay.feature.data.dto.Game
import com.rk.freeplay.feature.data.dto.GameDetail
import com.rk.freeplay.feature.domain.model.GameDetailUI
import com.rk.freeplay.feature.domain.model.GameUI

fun Game.convertGameUI(): GameUI {

    return GameUI(
        id = id,
        title = title,
        game = game,
        platform = platform,
        genre = genre,
        release = release,
        description = description,
        thumbnail = thumbnail
    )
}

fun GameDetail.convertGameDetailUI (): GameDetailUI {

    return GameDetailUI(
        id = id,
        title = title,
        thumbnail = thumbnail,
        publisher = publisher,
        platform = platform,
        description = description,
        game = game,
        genre = genre,
        profile = profile,
        requirements = requirement,
        release = release,
        pictures = pictures,
    )
}