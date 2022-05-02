package pattern_book.chapter3.decorator_starbuzz

class Whip(beverage: Beverage): CondimentDecorator(beverage) {
    override fun getDescription(): String = beverage.getDescription() + ", Whip"
    override fun cost(): Double = beverage.cost() + 0.10
}