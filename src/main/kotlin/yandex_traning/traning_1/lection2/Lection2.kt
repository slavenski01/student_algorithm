package yandex_traning.traning_1.lection2

fun main() {
    println(l2SlowSolution(listOf(13, 222, 1, 7, 401, 1)))
}

private fun l2SlowSolution(list: List<Int>): Pair<Int, Int> {

    var max1 = list[0]
    var max2 = list[1]

    for (i in list.indices) {
        if (list[i] > max1) {
            max2 = max1
            max1 = list[i]
        } else {
            if (list[i] > max2) max2 = list[i]
        }
    }
    return Pair(max1, max2)
}