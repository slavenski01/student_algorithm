package koltin_patterns_book.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val parent = launch(Dispatchers.Default) {
            val child = repeat(10) {
                
            }
        }
    }
}
