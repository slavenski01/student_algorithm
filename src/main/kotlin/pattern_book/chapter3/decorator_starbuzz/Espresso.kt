package pattern_book.chapter3.decorator_starbuzz

class Espresso: Beverage() {
    override fun getDescription(): String = "Espresso"
    override fun cost(): Double = 1.99
}