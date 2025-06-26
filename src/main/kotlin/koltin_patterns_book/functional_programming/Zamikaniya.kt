package koltin_patterns_book.functional_programming

fun main() {
    val next = counter()
    println(next())
    println(next())
    println(next())
    println(next())
    // замыкание, счетчик увеличивается, так как хранится ссылка на внешниюю переменой
    // таким образом есть состояние функции
}

private fun counter(): () -> Int {
    var i = 0
    return { i++ }
}