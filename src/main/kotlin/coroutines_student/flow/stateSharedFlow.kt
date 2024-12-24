package coroutines_student.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

suspend fun main(): Unit = coroutineScope {
    val sharedFlow = MutableStateFlow(0)

    repeat(10) {
        delay(90)
        sharedFlow.emit(it)
    }

    sharedFlow.collect {
        delay(100)
        println(it)
    }
}