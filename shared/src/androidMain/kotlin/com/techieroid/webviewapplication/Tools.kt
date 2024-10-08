package com.techieroid.webviewapplication

actual fun getWebViewHandler(): WebViewHandler {
    return AndroidWebViewHandler()
}