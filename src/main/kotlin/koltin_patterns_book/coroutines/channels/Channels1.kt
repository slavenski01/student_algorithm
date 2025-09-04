package koltin_patterns_book.coroutines.channels

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val channel = produce {
            (0..10).forEach {
                send(it)
            }
        }

        launch {
            channel.consumeEach {
                println(it)
            }
        }
    }
}