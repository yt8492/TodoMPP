package com.yt8492.todompp.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yt8492.todompp.ui.component.TodoCreateView
import com.yt8492.todompp.ui.model.Todo

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Root() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val (modalState, setModalState) = remember {
        mutableStateOf(ModalState.Closed)
    }
    val (todos, setTodos) = remember {
        mutableStateOf(listOf<Todo>())
    }
    LaunchedEffect(modalState) {
        if (modalState == ModalState.Closed) {
            scaffoldState.bottomSheetState.collapse()
        } else {
            scaffoldState.bottomSheetState.expand()
        }
    }
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text("TodoMPP")
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    setModalState(ModalState.Create)
                },
            ) {
                Icon(Icons.Filled.Add, null)
            }
        },
        sheetContent = {
            when (modalState) {
                ModalState.Create -> {
                    TodoCreateView(
                        onCreate = { title, content ->
                            val todo = Todo(
                                id = (todos.lastOrNull()?.id ?: 0) + 1,
                                title = title,
                                content = content,
                            )
                            setTodos(todos + todo)
                            setModalState(ModalState.Closed)
                        },
                        onCancel = {
                            setModalState(ModalState.Closed)
                        },
                    )
                }
                ModalState.Detail -> {

                }
                ModalState.Closed -> {}
            }
            Spacer(Modifier.height(400.dp))
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(todos, key = { it.id }) {
                Text(it.title)
            }
        }
    }
}

enum class ModalState {
    Create,
    Detail,
    Closed
}
