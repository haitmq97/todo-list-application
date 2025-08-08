package com.example.todolist.model

class Task (
    val id: Int,
    var title: String,
    var description: String,
    var isDone: Boolean = false
)