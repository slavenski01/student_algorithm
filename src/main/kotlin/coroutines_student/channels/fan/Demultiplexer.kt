package coroutines_student.channels.fan

import kotlinx.coroutines.channels.ReceiveChannel

class Demultiplexer<E>(vararg val rules: Rule<E>) {
    suspend fun consume(recv: ReceiveChannel<E>) {
        for(item in recv) {
            for(rule in rules) {
                if(rule.second(item)) rule.first.send(item)
            }
        }
        closeAll()
    }

    private fun closeAll() {
        rules.forEach { it.first.close() }
    }
}