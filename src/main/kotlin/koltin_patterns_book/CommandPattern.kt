package koltin_patterns_book

typealias Command = () -> Unit

fun main() {

}

private class Actor {
    fun attack() {
        println("attack")
    }

    fun move() {
        println("move")
    }
}

private class Executor() {
    private val orders = mutableListOf<Command>()

    fun addOrder(order: Command) {
        orders.add(order)
    }

    fun executeOrders() {
        while (orders.isNotEmpty()) {
            orders[0]()
            orders.removeFirst()
        }
    }
}