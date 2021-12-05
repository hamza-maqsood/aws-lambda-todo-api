package com.captis.awslambdaassignment.domain

data class Todo(
    val id: String,
    val description: String,
    var isDone: Boolean
)