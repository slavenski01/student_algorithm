package interview_preparation.my

import kotlin.concurrent.thread

var timer = 0

fun main() {

    val thread1 = thread(true) {
        for (i in 1..100000) {
            timer++
        }
    }

    val thread2 = thread {
        for (i in 1..100000) {
            timer--
        }
    }

    println("Main_End")
    println(timer)
}

//mutex
//val mutex = Mutex()
//var timer = 0
//
//fun main() = runBlocking {
//    val job1 = launch(Dispatchers.Default) {
//        for(i in 1..100000) {
//            mutex.withLock {
//                timer++
//            }
//        }
//    }
//
//    val job2 = launch(Dispatchers.Default) {
//        for(i in 1..100000) {
//            mutex.withLock {
//                timer--
//            }
//        }
//    }
//
//    job1.join()
//    job2.join()
//    println("Main_End")
//    println(timer) // Будет 0
//}

//import kotlinx.coroutines.*
//import kotlinx.coroutines.channels.Channel
//
//sealed class TimerCommand {
//    object Increment : TimerCommand()
//    object Decrement : TimerCommand()
//}
//
//fun main() = runBlocking {
//    val channel = Channel<TimerCommand>()
//    var timer = 0
//
//    // Обработчик команд
//    val processor = launch {
//        channel.consumeEach { command ->
//            when (command) {
//                is TimerCommand.Increment -> timer++
//                is TimerCommand.Decrement -> timer--
//            }
//        }
//    }
//
//    // Отправляем команды
//    launch {
//        repeat(100_000) { channel.send(TimerCommand.Increment) }
//    }
//
//    launch {
//        repeat(100_000) { channel.send(TimerCommand.Decrement) }
//    }
//
//    delay(1000) // Даём время на обработку (лучше использовать CompletableDeferred)
//    channel.close()
//    processor.join()
//
//    println("Final timer value: $timer") // Будет 0
//}