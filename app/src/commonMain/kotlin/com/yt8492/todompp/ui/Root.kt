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
import com.yt8492.todompp.ui.component.TodoDetailView
import com.yt8492.todompp.ui.component.TodoListView
import com.yt8492.todompp.ui.component.TodoView
import com.yt8492.todompp.ui.model.Todo

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Root() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val (modalState, setModalState) = remember {
        mutableStateOf<ModalState>(ModalState.Closed)
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
                is ModalState.Create -> {
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
                is ModalState.Detail -> {
                    TodoDetailView(
                        todo = modalState.todo,
                        onUpdate = { updated ->
                            setTodos(todos.map {
                                if (it.id == updated.id) {
                                    updated
                                } else {
                                    it
                                }
                            })
                            setModalState(ModalState.Closed)
                        },
                        onDelete = { deleted ->
                            setTodos(todos - deleted)
                            setModalState(ModalState.Closed)
                        },
                        onClose = {
                            setModalState(ModalState.Closed)
                        }
                    )
                }
                is ModalState.Closed -> {}
            }
            Spacer(Modifier.height(400.dp))
        }
    ) {
        TodoListView(
            todos = todos,
            onClickTodo = {
                setModalState(ModalState.Detail(it))
            }
        )
    }
}

sealed interface ModalState {
    object Create : ModalState
    data class Detail(val todo: Todo) : ModalState
    object Closed: ModalState
}
