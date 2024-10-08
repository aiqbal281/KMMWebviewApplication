package com.techieroid.webviewapplication

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

class AndroidWebViewHandler : WebViewHandler {
    @Composable
    override fun LoadUrl(url: String) {

        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    settings.apply {
                        javaScriptEnabled = false
                        builtInZoomControls = true
                        displayZoomControls = false
                        useWideViewPort = true
                        loadWithOverviewMode = true
                    }
                    webViewClient = WebViewClient()
                    webChromeClient = WebChromeClient()
                    loadUrl(url)
                }
            },
            update = { webView ->
                webView.loadUrl(url)
            }
        )

    }
}