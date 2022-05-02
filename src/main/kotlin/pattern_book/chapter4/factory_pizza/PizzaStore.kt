package pattern_book.chapter4.factory_pizza

abstract class PizzaStore {

    abstract fun createPizza(type: String): Pizza?

    fun orderPizza(type: String) {
        val pizza = createPizza(type)
        pizza?.prepare()
        pizza?.bake()
        pizza?.cut()
        pizza?.box()
    }
}