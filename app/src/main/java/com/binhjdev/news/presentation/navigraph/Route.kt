package com.binhjdev.news.presentation.navigraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object BookmarkScreen : Route(route = "bookmarkScreen")
    object DetailsScreen : Route(route = "detailsScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object KookNewsNavigation : Route(route = "kookNewsNavigation")
    object KookNewsNavigatorScreen : Route(route = "kooksNewsNavigatorScreen")
}
