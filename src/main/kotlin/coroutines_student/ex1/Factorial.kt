package coroutines_student.ex1

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val scope =
        CoroutineScope(
            Job()
                    + CoroutineExceptionHandler { coroutineContext, throwable -> println(throwable.message) }
        )
    scope.launch {
        delay(3000)
        error("123")
    }

    val job = scope.launch {
        repeat(5) {
            delay(999)
            println("number: $it, isActive: $isActive")
        }
    }

    job.join()
}