package pattern_book.chapter3.decorator_starbuzz

abstract class Beverage {
    private val description = "Unknown Beverage"

    open fun getDescription() = description

    abstract fun cost(): Double
}