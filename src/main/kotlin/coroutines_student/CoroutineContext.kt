package coroutines_student

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() {
    val dispatcherDefault = Dispatchers.Default
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("problem with $throwable")
    }
    val emptyParentJob = Job()
    val combinedContext = dispatcherDefault + coroutineExceptionHandler + emptyParentJob
    GlobalScope.launch(combinedContext) {
        println(Thread.currentThread().name)
    }
    Thread.sleep(50)
}

interface CoroutineContextProvider {
    fun context(): CoroutineContext
}