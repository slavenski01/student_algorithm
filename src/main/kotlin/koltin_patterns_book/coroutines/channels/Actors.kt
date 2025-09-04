package koltin_patterns_book.coroutines.channels

import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@OptIn(ObsoleteCoroutinesApi::class)
fun main() {
    runBlocking {
        val actor = actor<Long>(capacity = 10) {
            var prev = 0L
            channel.consumeEach {
                println(it - prev)
                prev = it
                delay(100)
            }
        }
        repeat(10) {
            actor.send(System.currentTimeMillis())
        }
        actor.close().also { println("Done sending") }
    }
}