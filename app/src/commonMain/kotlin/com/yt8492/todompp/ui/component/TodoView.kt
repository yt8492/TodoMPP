package com.yt8492.todompp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yt8492.todompp.ui.model.Todo

@Composable
fun TodoView(
    todo: Todo,
    onClickTodo: (Todo) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClickTodo(todo)
            },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = todo.title,
                fontSize = 16.sp,
            )
            Spacer(Modifier.weight(1f))
            Icon(Icons.Filled.ArrowForward, null)
        }
        Divider()
    }
}
