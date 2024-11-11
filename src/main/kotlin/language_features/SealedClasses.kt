package language_features

sealed interface Sale
sealed class Money: Sale {
    class Rub(val nameMoney: String): Money()
    class Tugrik(val nameMoney: String, private val country: String): Money()

    fun getName() = when(this) {
        is Rub -> nameMoney
        is Tugrik -> nameMoney
    }
}

class Outer(val outerClassName: String = "outerName") {

    init {
        printAllNames()
    }

    @JvmInline
    value class ValueClass(val valueClassName: String)

    fun printAllNames() = println("$outerClassName, ${ValueClass("123").valueClassName}")
}

fun main() {
    val money = Money.Rub(nameMoney = "214")
    val outer = Outer()
    println(money.getName())
    println(outer.printAllNames())
}