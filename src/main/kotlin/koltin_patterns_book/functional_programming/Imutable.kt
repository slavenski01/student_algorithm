package koltin_patterns_book.functional_programming

import kotlin.concurrent.thread

fun main() {
    val scores = listOf(Player(0), Player(0))

    val threads = List(2) {
        thread {
            for (i in 0..1000) {
                scores[0].score++
            }
        }
    }

    for (t in threads) {
        t.join()
    }

    println(scores[0].score) //race condition

    printAndClear(mutableListOf("a", "b", "c")) //concurrent exeption
}

private fun <T> printAndClear(items: MutableList<T>) {
    for (i in items) {
        println(i)
        items.remove(i)
    }
}

private data class Player(var score: Int)