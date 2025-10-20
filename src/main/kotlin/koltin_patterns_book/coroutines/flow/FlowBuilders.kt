package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val flow: Flow<Int> = flow {
            for (i in 1..3) {
                emit(i)
            }
        }

        flow.onEach {
            println(it)
        }
            .flowOn(Dispatchers.Default)
            .collect()

        val channelFlow = channelFlow {
            send(1)
            send(2)
            send(3)
        }
    }
}