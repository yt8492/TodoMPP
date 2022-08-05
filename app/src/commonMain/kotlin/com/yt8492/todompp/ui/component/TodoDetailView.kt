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
import com.yt8492.todompp.ui.model.Todo

@Composable
fun TodoDetailView(
    todo: Todo,
    onUpdate: (Todo) -> Unit,
    onDelete: (Todo) -> Unit,
    onClose: () -> Unit,
) {
    val (title, setTitle) = remember {
        mutableStateOf(todo.title)
    }
    val (content, setContent) = remember {
        mutableStateOf(todo.content)
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
                onClick = onClose,
            ) {
                Text("Close")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    onDelete(todo)
                }
            ) {
                Text("Delete")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    onUpdate(todo.copy(title = title, content = content))
                },
            ) {
                Text("Update")
            }
        }
    }
}
