package koltin_patterns_book.threads_coroutines

import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread

fun main() {
    example()
}

private fun example() {
    var counter = 0
    val latch = CountDownLatch(100000)
    repeat(100) {
        thread {
            repeat(1000) {
                synchronized(latch) {
                    counter++
                    latch.countDown()
                }
            }
        }
    }

    latch.await()
    println("Counter: $counter")
}