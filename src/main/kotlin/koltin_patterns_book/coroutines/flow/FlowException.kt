package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        println("exeption start")
        flow {
            var i = 3
            repeat(5) {
                emit(10 / i--)
            }
        }.catch { e ->
            println("error ${e.message}")
        }.collect {
            println(it)
        }

        println("exeption onComplection")
        flow {
            emit(1)
            emit(2)
        }.onCompletion { e ->
            if (e != null) {
                println("error: $e")
            } else {
                println("on successfull complete")
            }
        }.collect {
            println(it)
        }

        println("exeption repeat")
        flow {
            repeat(3) {
                val randomNextInf = Random.nextInt(10)
                if (randomNextInf > 4) throw IllegalArgumentException("ERROR")
                emit(randomNextInf)
            }
        }
            .retry(10) {
                println(it)
                true
            }
            .collect {
                println(it)
            }
    }
}