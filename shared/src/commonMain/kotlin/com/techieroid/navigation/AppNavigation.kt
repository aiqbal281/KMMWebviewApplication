package com.techieroid.navigation

sealed class AppNavigation(
    val route: String
) {

    object Main : AppNavigation(route = "Main")
}
