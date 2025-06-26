package koltin_patterns_book.functional_programming

fun main() {
    println(subtract(50, 8))
    println(caringSubtract(50)(40))
    println(bestCaringSubtract(50)(50))
}

private fun subtract(x: Int, y: Int): Int {
    return x - y
}

private fun caringSubtract(x: Int) = fun (y: Int): Int {
    return x - y
}

private fun bestCaringSubtract(x: Int) = {y: Int -> x - y}