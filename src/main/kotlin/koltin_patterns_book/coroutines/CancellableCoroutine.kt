package koltin_patterns_book.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

suspend fun main() = coroutineScope {
    val cancellable = launch {
        try {
            for (i in 0..10) {
                println("Cancellable: $i")
                yield()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    val notCancellable = launch {
        for (i in 0..10) {
            println("Not cancellable $i")
        }
    }

    println("Canceling cancellable")
    cancellable.cancel()
    println("Canceling not cancellable")
    notCancellable.cancel()

    cancellable.join()
    notCancellable.join()
}