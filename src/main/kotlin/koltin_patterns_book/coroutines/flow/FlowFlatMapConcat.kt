package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val flowA = ('A'..'B').map { it.toString() }.asFlow()
        val flowB = ('a'..'b').map { it.toString() }.asFlow()

        flowA.flatMapConcat { i -> flowB.map { j -> i + j } }
            .onEach { println(it) }
            .collect()
    }
}