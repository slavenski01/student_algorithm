package koltin_patterns_book.functional_programming

fun main() {
    val summer = sumanaizer()
    input.forEach {
        summer(it)
    }
}

private val input = listOf(
    setOf(1, 2, 3),
    setOf(2, 1, 3),
    setOf(2, 3, 1),
    setOf(4, 5, 6)
)

private fun sumanaizer(): (Set<Int>) -> Double {
    val resultCache = mutableMapOf<Set<Int>, Double>()
    return { numbers ->
        resultCache.computeIfAbsent(numbers, ::sumSet)
    }
}

private fun sumSet(set: Set<Int>): Double {
    return set.sumOf { it.toDouble() }
}