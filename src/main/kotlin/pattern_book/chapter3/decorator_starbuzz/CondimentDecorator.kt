package pattern_book.chapter3.decorator_starbuzz

abstract class CondimentDecorator(
    val beverage: Beverage
): Beverage() {
    abstract override fun getDescription(): String
    override fun cost(): Double {
        return beverage.cost()
    }
}