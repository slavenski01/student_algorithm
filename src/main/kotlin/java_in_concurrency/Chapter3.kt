package java_in_concurrency

var ready: Boolean = false
var number: Int = 0

class ReaderThread : Thread() {
    override fun run() {
        while (!ready) yield()
        println(number)
    }
}
fun main() {
    ReaderThread().start()
    number = 42
    ready = true
}