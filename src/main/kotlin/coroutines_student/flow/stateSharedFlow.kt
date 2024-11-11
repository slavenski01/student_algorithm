package coroutines_student.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow

suspend fun main(): Unit = coroutineScope {
    val sharedFlow = MutableSharedFlow<Int>(0)

    repeat(10) {
        delay(90)
        sharedFlow.emit(it)
    }

    sharedFlow.collect {
        println(it)
    }
}