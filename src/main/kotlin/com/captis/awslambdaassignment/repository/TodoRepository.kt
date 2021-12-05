package com.captis.awslambdaassignment.repository

import com.captis.awslambdaassignment.domain.Todo
import org.springframework.stereotype.Repository

@Repository
class TodoRepository {

    private val todos = mutableListOf<Todo>().apply {
        add(Todo("1", "Buy eggs", false))
        add(Todo("2", "Workout", false))
        add(Todo("3", "School Homework", true))
        add(Todo("4", "Finish the book", true))
    }

    fun getAllTodos(): List<Todo> = todos

    fun addTodo(todo: Todo): List<Todo> {
        todos.add(todo)
        return todos
    }

    fun updateTodo(id: String): Todo? {
        val todoToUpdate = todos.find {
            it.id == id
        } ?: return null
        todoToUpdate.isDone = true
        return todoToUpdate
    }

    fun deleteTodo(id: String): Boolean = todos.removeIf { it.id == id }

    fun getTodo(id: String): Todo? = todos.find { it.id == id }
}