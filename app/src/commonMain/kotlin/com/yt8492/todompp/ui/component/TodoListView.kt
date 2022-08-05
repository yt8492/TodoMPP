package com.yt8492.todompp.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yt8492.todompp.ui.model.Todo

@Composable
fun TodoListView(
    todos: List<Todo>,
    onClickTodo: (Todo) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(todos, key = { it.id }) {
            TodoView(it)
        }
    }
}
