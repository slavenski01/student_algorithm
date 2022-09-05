package coroutines_student

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() {
    var a = 50
    runBlocking {
        delay(1000)
        a.loadImage { a = 1000 }
        println(a)
    }
}

suspend fun Int.loadImage(
    onSuccess: () -> Unit
) {
    delay(5000)
    onSuccess.invoke()
}