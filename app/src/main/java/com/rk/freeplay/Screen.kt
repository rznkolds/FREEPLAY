package com.rk.freeplay

import com.rk.freeplay.common.Constant.DETAIL_ARGUMENT_KEY

sealed class Screen(val route: String) {

    object Home : Screen(route = "home_screen")

    object Detail : Screen(route = "detail_screen/{${DETAIL_ARGUMENT_KEY}}") {

        fun sendId(id:Int):String = "detail_screen/$id"
    }
}
