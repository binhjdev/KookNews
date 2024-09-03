package com.binhjdev.news.presentation.navigraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.binhjdev.news.presentation.on_boarding.OnBoardingScreen
import com.binhjdev.news.presentation.on_boarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    onEvent = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.KookNewsNavigation.route,
            startDestination = Route.KookNewsNavigatorScreen.route
        ) {
            composable(route = Route.KookNewsNavigatorScreen.route){
                Text(text = "Kook News Navigator Screen")
            }
        }
    }
}