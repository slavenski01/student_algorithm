package coroutines_student.channels

import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor

object completionHandler : CompletionHandler {
    override fun invoke(cause: Throwable?) {
        println("Complete")
    }
}
fun main() {
    val actor = GlobalScope.actor<String>(
        onCompletion = completionHandler,
        capacity = 10
    ) {
        for(data in channel) {
            println(data)
        }
    }

    (0..10).forEach {
        actor.trySend(it.toString())
    }
    actor.close()

    Thread.sleep(500)
}