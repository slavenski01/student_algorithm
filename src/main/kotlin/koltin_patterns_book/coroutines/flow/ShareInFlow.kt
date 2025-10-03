package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

@OptIn(DelicateCoroutinesApi::class)
private fun main() {
    runBlocking {
        val originalFlow = flowOf(1, 2, 3, 4, 5)
            .onEach { println("Sending $it from ${Thread.currentThread().name}") }

        val sharedFlow = originalFlow
            .shareIn(
                scope = CoroutineScope(newFixedThreadPoolContext(4, "MyDispatcher")),
                started = SharingStarted.Lazily,
                replay = 2
            )

        repeat(5) { id ->
            launch(Dispatchers.Default) {
                sharedFlow.map { value ->
                    println("Coroutine $id got $value on ${Thread.currentThread().name}")
                }.collect()
            }
        }
    }
}