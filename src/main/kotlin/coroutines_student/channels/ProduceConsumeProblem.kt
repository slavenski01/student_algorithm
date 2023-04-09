package coroutines_student.channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.isActive
import kotlin.random.Random

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    val producer = GlobalScope.produce(capacity = 10) {
        while (isActive) {
            if(!isClosedForSend) {
                val number = Random.nextInt(0, 30)
                if(trySend(number).isSuccess) {
                    println("$number, success")
                } else {
                    println("error")
                }
            }
        }
    }
    Thread.sleep(30)
    producer.cancel()
    while (!producer.isClosedForReceive) {
        val number = producer.tryReceive()

        if(number.getOrNull() != null) {
            println("consume: ${number.getOrNull()}")
        }
    }
}