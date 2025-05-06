package interview_preparation.algorithms.yandex

/**
 * Найти элементы из первой отсортированной последовательности,
 * которых нет во второй отсортированной последовательности.
 *
 * Временная сложность: O(n+m), где n и m - длины последовательностей
 * Пространственная сложность: O(1), не считая результирующий список
 */

fun main() {
    println(filterSortedList(listOf(1, 2, 3), listOf(3, 4))) // [1, 2]
    println(filterSortedList(listOf(1, 2, 3), listOf(1, 2, 3))) // []
    println(filterSortedList(listOf(1, 2, 3), listOf(4, 5, 6))) // [1, 2, 3]

    println(filterSortedList(listOf(1, 3, 4, 5, 22, 73), listOf(2, 3, 5)))
}

fun filterSortedList(list1: List<Int>, list2: List<Int>): List<Int> {
    val result = mutableListOf<Int>()

    var i = 0
    var j = 0

    while (i < list1.size && j < list2.size) {
        if (list1[i] > list2[j]) {
            j++
        } else if (list1[i] < list2[j]) {
            result.add(list1[i])
            i++
        } else {
            i++
            j++
        }
    }

    while (i < list1.size) {
        result.add(list1[i])
        i++
    }

    return result
}