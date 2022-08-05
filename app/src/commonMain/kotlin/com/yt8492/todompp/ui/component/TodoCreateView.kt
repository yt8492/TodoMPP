package com.yt8492.todompp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoCreateView(
    onCreate: (title: String, content: String) -> Unit,
    onCancel: () -> Unit,
) {
    val (title, setTitle) = remember {
        mutableStateOf("")
    }
    val (content, setContent) = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        TextField(
            value = title,
            onValueChange = setTitle,
            placeholder = {
                Text("Title")
            },

        )
        TextField(
            value = content,
            onValueChange = setContent,
            placeholder = {
                Text("input your todo detail")
            },
            modifier = Modifier.fillMaxWidth(),
        )
        Row {
            Button(
                onClick = onCancel,
            ) {
                Text("Cancel")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    onCreate(title, content)
                },
            ) {
                Text("Create")
            }
        }
    }
}