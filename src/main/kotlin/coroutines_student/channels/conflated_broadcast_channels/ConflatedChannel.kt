package coroutines_student.channels.conflated_broadcast_channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach

@OptIn(ObsoleteCoroutinesApi::class)
fun main() {
    val colors = arrayListOf("RED", "GREEN", "BLUE", "YELLOW", "WHITE", "BLACK")

    val conflatedBroadcastChannel = ConflatedBroadcastChannel<String>()

    runBlocking {
        conflatedBroadcastChannel.apply {
            send(colors[0])
            send(colors[2])
            send(colors[1])
        }

        GlobalScope.launch {
            conflatedBroadcastChannel.consumeEach {
                println("Consumer1: $it")
            }
        }

        GlobalScope.launch {
            conflatedBroadcastChannel.consumeEach {
                println("Consumer2: $it")
            }
        }

        conflatedBroadcastChannel.apply {
            send(colors[3])
            send(colors[4])
            send(colors[4])
        }

        readln()

        conflatedBroadcastChannel.close()
    }
}