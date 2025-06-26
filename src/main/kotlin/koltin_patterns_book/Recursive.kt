package koltin_patterns_book

fun main() {
    println(sumList(0, 0, listOf(1, 2, 3)))
    println(sumList(0, 0, List(1_000_000){it}))
}

private tailrec fun sumList(i: Int, sum: Long, numbers: List<Int>): Long {
    if (i == numbers.size) {
        return sum
    } else {
        return sumList(i + 1, sum + numbers[i], numbers)
    }
}