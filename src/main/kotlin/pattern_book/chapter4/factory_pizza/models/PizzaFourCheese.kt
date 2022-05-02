package pattern_book.chapter4.factory_pizza.models

import pattern_book.chapter4.factory_pizza.Pizza

class PizzaFourCheese: Pizza {
    override fun prepare() {
        println("prepare")
    }

    override fun bake() {
        println("bake")
    }

    override fun cut() {
        println("cut")
    }

    override fun box() {
        println("box")
    }
}