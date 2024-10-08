package com.techieroid.ui

import androidx.compose.runtime.Composable
import com.techieroid.navigation.MainNavigation
import com.techieroid.webviewapplication.getWebViewHandler
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator


@Composable
internal fun MainNav(){
    val navigator = rememberNavigator()
    val webViewHandler = getWebViewHandler()
    NavHost(
        navigator = navigator,
        initialRoute = MainNavigation.WebView.route,
    ) {
        scene(route = MainNavigation.WebView.route) {
            WebViewScreen(
                webViewHandler = webViewHandler,
                url = "https://github.com/aiqbal281"
            )
        }
    }

}