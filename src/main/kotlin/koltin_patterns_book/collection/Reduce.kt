package koltin_patterns_book.collection

fun main() {
    val list = listOf(1, 2, 3, 5)
    println(list.reduce(operation = { currentValue, item ->
        currentValue + item
    }))
    println(list.fold(initial = 9, operation = { currentValue, item ->
        currentValue + item
    }))
}