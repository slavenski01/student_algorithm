@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package coroutines_student.channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    val intArray = arrayOf(1, 2, 3, 4, 5)

    fun produceInt() = GlobalScope.produce {
        for (int in intArray) {
            send(int)

            if(int == 3) close()
        }
    }

    runBlocking {
        val ints = produceInt()
        ints.consumeEach {
            println(it)
        }
        println("Done")
    }
}