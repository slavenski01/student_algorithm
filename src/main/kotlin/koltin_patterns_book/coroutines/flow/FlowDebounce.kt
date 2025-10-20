package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.runBlocking

@OptIn(FlowPreview::class)
fun main() {
    runBlocking {
        val flow = flow {
            repeat(10) {
                delay(700L)
                emit(it)
            }
        }.sample(1000L)

        flow.collect { println(it) }
    }
}