package com.yt8492.todompp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yt8492.todompp.ui.TodoRootView
import com.yt8492.todompp.ui.theme.TodoMPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoMPPTheme {
                // A surface container using the 'background' color from the theme
                TodoRootView()
            }
        }
    }
}
