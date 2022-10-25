package coroutines_student.channels.broadcast_channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ObsoleteCoroutinesApi::class)
fun main() {
    val intArray = intArrayOf(1, 2, 3, 4, 5)

    val broadCastChannel = BroadcastChannel<Int>(capacity = 3)

    runBlocking {
        broadCastChannel.apply {
            send(intArray[0])
            send(intArray[1])
            send(intArray[2])
        }

        GlobalScope.launch {
            broadCastChannel.consumeEach {
                println("Consumer1: $it")
            }
        }

        GlobalScope.launch {
            broadCastChannel.consumeEach {
                println("Consumer2: $it")
            }
        }

        broadCastChannel.apply {
            send(intArray[3])
            send(intArray[4])
        }

        println("Press any key to stop...")
        readln()

        broadCastChannel.close()
    }
}