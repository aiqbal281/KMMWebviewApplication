package com.techieroid.webviewapplication

import androidx.compose.runtime.Composable
import kotlinx.cinterop.readValue
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.WebKit.WKWebView
import platform.WebKit.WKWebViewConfiguration

class IOSWebViewHandler : WebViewHandler {

    private val webView: WKWebView = WKWebView(frame = CGRectZero.readValue(), configuration = WKWebViewConfiguration())

    @Composable
    override fun LoadUrl(url: String) {
        val nsUrl = NSURL(string = url)
        val request = NSURLRequest(nsUrl)
        webView.loadRequest(request)
    }
}