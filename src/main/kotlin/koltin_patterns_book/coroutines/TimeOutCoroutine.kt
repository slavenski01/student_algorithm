package koltin_patterns_book.coroutines

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main() {
    coroutineScope {
        val coroutine = async {
            withTimeout(500) {
                try {
                    val time = Random.nextLong(1000)
                    println("time: $time")
                    delay(time)
                    "Profile"
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        val result = try {
            coroutine.await()
        } catch (e: TimeoutCancellationException) {
            "Not Profile"
        }

        println(result)
    }
}