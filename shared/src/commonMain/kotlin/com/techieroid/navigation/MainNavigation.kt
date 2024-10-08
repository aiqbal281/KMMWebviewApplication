package com.techieroid.navigation

sealed class MainNavigation(
    val route: String
) {
    object WebView : MainNavigation(route = "WebView")
}