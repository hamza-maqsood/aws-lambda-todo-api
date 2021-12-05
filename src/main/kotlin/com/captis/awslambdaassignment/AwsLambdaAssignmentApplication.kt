package com.captis.awslambdaassignment

import com.captis.awslambdaassignment.domain.Todo
import com.captis.awslambdaassignment.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.function.Function
import java.util.function.Supplier

@SpringBootApplication
class AwsLambdaAssignmentApplication {

    @Autowired
    lateinit var todoRepository: TodoRepository

    @Bean
    fun greet(): (String) -> String {
        return { input -> "Hi, $input" }
    }

    @Bean
    fun getAllTodos(): Supplier<List<Todo>> {
        return Supplier {
            todoRepository.getAllTodos()
        }
    }

    @Bean
    fun getTodoById(): Function<String, Todo?> {
        return Function {
            return@Function todoRepository.getTodo(it)
        }
    }

    @Bean
    fun addTodo(): Function<Todo, List<Todo>> {
        return Function {
            return@Function todoRepository.addTodo(it)
        }
    }

    @Bean
    fun deleteTodo(): Function<String, Boolean> {
        return Function {
            return@Function todoRepository.deleteTodo(it)
        }
    }

    @Bean
    fun updateTodo(): Function<String, Todo?> {
        return Function {
            return@Function todoRepository.updateTodo(it)
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AwsLambdaAssignmentApplication::class.java, *args)
        }
    }
}
