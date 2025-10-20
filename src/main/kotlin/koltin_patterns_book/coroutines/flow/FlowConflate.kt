package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

//conflate - функция чтобы гарантировать что все старые данные отбрасываются

fun main() {
    runBlocking {
        val flow = flow {
            var i = 0
            while (true){
                emit(++i)
                delay(100)
            }
        }

        var second = 0
        flow.conflate().onEach {
            delay(1000)
            second++
            println("number: $it, second: $second")
        }.flowOn(Dispatchers.Default)
            .collect()
    }
}