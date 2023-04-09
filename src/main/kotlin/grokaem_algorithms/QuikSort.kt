package grokaem_algorithms

fun main() {
    println(quicksort(listOf(1, 5, 3, 4, 2)))
}

fun quicksort(items: List<Int>): List<Int> {
    if (items.count() < 2) {
        return items
    }
    val pivot = items[items.count() / 2]

    val equal = items.filter { it == pivot }

    val less = items.filter { it < pivot }

    val greater = items.filter { it > pivot }

    return quicksort(less) + equal + quicksort(greater)
}