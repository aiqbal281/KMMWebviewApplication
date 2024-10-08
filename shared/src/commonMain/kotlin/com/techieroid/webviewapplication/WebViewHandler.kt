package com.techieroid.webviewapplication

import androidx.compose.runtime.Composable

interface WebViewHandler {

    @Composable
    fun LoadUrl(url: String)
}