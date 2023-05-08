package yandex_traning.traning_1.lection2

/**
 * Формат ввода
 * В первой строке задается одно натуральное число N,
 * не превосходящее 1000 – размер массива.
 * Во второй строке содержатся N чисел – элементы массива (целые числа, не превосходящие по модулю 1000).
 * В третьей строке вводится одно целое число x, не превосходящее по модулю 1000.
 *
 * Формат вывода
 * Вывести значение элемента массива, ближайшее к x.
 * Если таких чисел несколько, выведите любое из них.
 *
 * Ввод
 * 5
 * 1 2 3 4 5
 * 6
 * Вывод
 * 5
 **/
fun main() {
    val listSize = readLine()?.toInt() ?: return
    val listNumbers = readLine() ?: return
    val listTarget = listNumbers.split(" ").map { it.toInt() }

    if (listTarget.size != listSize) return

    val targetNumber = readLine()?.toInt() ?: return

    println(hw3solution(listTarget, targetNumber))
}

private fun hw3solution(list: List<Int>, targetX: Int): String {
    var minIndex = 0

    for (i in 1 until list.size) {
        val crntDiff = Math.abs(targetX - list[i])
        if (Math.abs(targetX - list[minIndex]) > crntDiff) {
            minIndex = i
        }
    }

    return list[minIndex].toString()
}