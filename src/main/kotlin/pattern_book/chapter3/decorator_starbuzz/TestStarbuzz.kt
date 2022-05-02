package pattern_book.chapter3.decorator_starbuzz

fun main() {
    val orders = mutableListOf<Beverage>()
    var beverage: Beverage = Espresso()
    beverage = Soy(beverage)
    beverage = Whip(beverage)
    orders.add(beverage)

    println(orders[0].getDescription())
    println(orders[0].cost())
}