package com.yt8492.todompp.jvm

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.yt8492.todompp.ui.Root

fun main() {
    singleWindowApplication(
        title = "TodoMPP",
        state = WindowState(size = DpSize(800.dp, 600.dp)),
    ) {
        Root()
    }
}
