package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        val numbersFlow = flow {
            (0..10).forEach {
                println("Sending $it")
                emit(it)
            }
        }

        (1..4).forEach { coroutineId ->
            delay(2000L)
            launch(Dispatchers.Default) {
                numbersFlow.buffer().collect { number ->
                    delay(500)
                    println("coroutineId: $coroutineId, number: $number")
                }
            }
        }
    }
}