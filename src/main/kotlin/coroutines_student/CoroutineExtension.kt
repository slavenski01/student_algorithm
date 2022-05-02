package coroutines_student

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine

fun main() {

}

suspend fun <T : Any> getValue(provider: () -> T): T =
    suspendCoroutine { continuation ->
        continuation.resumeWith(Result.runCatching { provider() })
    }

fun executeBackground(block: suspend () -> Unit) {
    GlobalScope.launch { block() }
}

fun executeMain(block: suspend () -> Unit) {
    GlobalScope.launch(Dispatchers.Main) { block() }
}