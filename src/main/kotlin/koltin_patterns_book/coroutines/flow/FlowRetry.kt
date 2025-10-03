package koltin_patterns_book.coroutines.flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class Http5XX(message: String) : Throwable(message)
class Http4XX(message: String) : Throwable(message)

fun main() {
    runBlocking {
        flow {
            repeat(3) {
                emit(doSomethingHttp())
            }
        }.retryWhen { e: Throwable, attempts: Long -> //оператор который проверяет надо делать ретрай или нет
            println("Got $e, retry")
            when { //условие которое устанавливает надо ли делать или нет
                (e is Http4XX) && attempts > 10 -> false
                (e is Http5XX) && attempts > 3 -> false
                else -> true
            }
        }.collect {
            println(it)
        }
    }
}

private fun doSomethingHttp(): Int {
    val randomNumber = Random.nextInt(10)
    return when (randomNumber) {
        in 0..2 -> throw Http4XX(randomNumber.toString())
        in 3..5 -> throw Http5XX(randomNumber.toString())
        else -> randomNumber
    }
}