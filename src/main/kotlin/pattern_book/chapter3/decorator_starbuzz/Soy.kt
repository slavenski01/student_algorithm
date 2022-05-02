package pattern_book.chapter3.decorator_starbuzz

class Soy(beverage: Beverage): CondimentDecorator(beverage = beverage) {
    override fun cost(): Double = beverage.cost() + 0.20
    override fun getDescription(): String = beverage.getDescription() + ", Soy"
}