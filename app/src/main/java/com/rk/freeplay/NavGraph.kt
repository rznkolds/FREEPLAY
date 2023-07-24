package com.rk.freeplay

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rk.freeplay.common.Constant
import com.rk.freeplay.feature.presentation.detail.DetailScreen
import com.rk.freeplay.feature.presentation.home.HomeScreen

@Composable
fun NavGraph() {

    val controller = rememberNavController()

    NavHost(
        navController = controller,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(controller = controller)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            DetailScreen(it.arguments?.getInt(Constant.DETAIL_ARGUMENT_KEY))
        }
    }
}