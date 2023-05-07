package yandex_traning.traning_1.lection2

import kotlin.random.Random

/**
 * По последовательности чисел во входных данных определите ее вид:

CONSTANT – последовательность состоит из одинаковых значений
ASCENDING – последовательность является строго возрастающей
WEAKLY ASCENDING – последовательность является нестрого возрастающей
DESCENDING – последовательность является строго убывающей
WEAKLY DESCENDING – последовательность является нестрого убывающей
RANDOM – последовательность не принадлежит ни к одному из вышеупомянутых типов
Формат ввода
По одному на строке поступают числа последовательности ai, |ai| ≤ 109.

Признаком окончания последовательности является число -2× 109. Оно в последовательность не входит.

Формат вывода
В единственной строке выведите тип последовательности.
 **/

fun main() {
//    var flag = true
//    val list = mutableListOf<Int>()
//    while (flag) {
//        val stdIn = readLine()?.toInt() ?: return
//        if (stdIn != -2000000000) {
//            list.add(stdIn)
//        } else {
//            flag = false
//        }
//    }
//
//    println(hw2solution(list))
    test()
}

private fun test() {
    val mutableList = mutableListOf<Int>()
    var last = -1
    for (i in 0..5) {
        last = Random.nextInt(-10000, last)
        mutableList.add(Random.nextInt(-5, 0))
    }
    println(mutableList)
    println(hw2solution(mutableList))
}

private fun hw2solution(list: List<Int>): String {

    if (list[0] == list.last()) {
        for (i in 0..list.size - 2) {
            if (list[i] != list[i + 1]) return RANDOM
        }
        return CONSTANT
    }

    if (list[0] < list.last()) {
        for (i in 0..list.size - 2) {
            if (list[i] > list[i + 1]) {
                return RANDOM
            }
        }
        for (i in 0..list.size - 2) {
            if (list[i] == list[i + 1]) {
                return WEAKLY_ASCENDING
            }
        }
        return ASCENDING
    }

    if (list[0] > list.last()) {
        for (i in 0..list.size - 2) {
            if (list[i] < list[i + 1]) {
                return RANDOM
            }
        }

        for (i in 0..list.size - 2) {
            if (list[i] == list[i + 1]) {
                return WEAKLY_DESCENDING
            }
        }
        return DESCENDING
    }

    return RANDOM
}

private const val CONSTANT = "CONSTANT"
private const val ASCENDING = "ASCENDING"
private const val WEAKLY_ASCENDING = "WEAKLY ASCENDING"
private const val DESCENDING = "DESCENDING"
private const val WEAKLY_DESCENDING = "WEAKLY DESCENDING"
private const val RANDOM = "RANDOM"