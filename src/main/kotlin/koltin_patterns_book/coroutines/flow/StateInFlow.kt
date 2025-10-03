package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val originalFlow = flowOf(1, 2, 3, 4, 5)
            .onEach { println("Sending $it from ${Thread.currentThread().name}") }

        val stateFlow = originalFlow.stateIn(
            scope = CoroutineScope(Dispatchers.Default),
            started = SharingStarted.WhileSubscribed(),
            initialValue = 0
        )

        repeat(5) { id ->
            launch(Dispatchers.Default) {
                stateFlow.map { value ->
                    println("Coroutine $id got $value on ${Thread.currentThread().name}")
                }.collect()
            }
            delay(100)
        }
    }
}