package coroutines_student

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val launch = GlobalScope.launch {
        val dataDeferred = getUserByIdFromNetwork(1312)
        println("Not cancelled")
        // do something with the data
        val data = dataDeferred.await()
        println(data)
    }
    Thread.sleep(50)
    launch.cancel()
    while (true) { // stops the program from finishing
    }
}

private suspend fun getUserByIdFromNetwork(userId: Int) =
    GlobalScope.async {
        println("Retrieving user from network")
        delay(3000)
        println("Still in the coroutine")
        User(userId, "Filip", "Babic") // we simulate the network call
    }
data class User(
    val id: Int,
    val name: String,
    val lastName: String
)