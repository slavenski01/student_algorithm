package coroutines_student

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>()

    launch {
        repeat(5) {
            sharedFlow.emit(it)
            delay(100)
        }
    }

    launch {
        sharedFlow.collect {
            println(it)
        }
    }
}