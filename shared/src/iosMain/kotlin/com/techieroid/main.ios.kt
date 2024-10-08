package com.techieroid

import App
import androidx.compose.ui.window.ComposeUIViewController
import com.techieroid.common.Context

fun mainViewController() = ComposeUIViewController { App(Context()) }

