package com.techieroid.webviewapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform