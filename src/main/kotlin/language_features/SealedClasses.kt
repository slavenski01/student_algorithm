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

fun main() {
    val money = Money.Rub(nameMoney = "214")
    println(money.getName())
}