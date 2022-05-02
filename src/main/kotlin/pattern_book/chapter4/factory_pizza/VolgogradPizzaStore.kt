package pattern_book.chapter4.factory_pizza

import pattern_book.chapter4.factory_pizza.models.PizzaDefault
import pattern_book.chapter4.factory_pizza.models.PizzaFourCheese

class VolgogradPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza? {
        return when (type) {
            "default" -> PizzaDefault()
            "four" -> PizzaFourCheese()
            else -> null
        }
    }
}