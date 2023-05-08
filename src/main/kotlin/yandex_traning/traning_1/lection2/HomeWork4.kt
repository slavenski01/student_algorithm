package yandex_traning.traning_1.lection2

/**
 * Дан список чисел. Определите, сколько в этом списке элементов,
 * которые больше двух своих соседей и выведите количество таких элементов.
 *
 * Формат ввода
 * Вводится список чисел. Все числа списка находятся на одной строке.
 *
 * Формат вывода
 * Выведите ответ на задачу.
 *
 * Пример 1
 * Ввод
 * 1 2 3 4 5
 * Вывод
 * 0
 **/

fun main() {
    val strIn = readLine() ?: return
    val listNumbers = strIn.split(" ").map { it.toInt() }

    println(hw4solve(listNumbers))
}

private fun hw4solve(list: List<Int>): Int {
    var crntAns = 0
    for (i in 1..list.size - 2) {
        if (list[i] > list[i - 1] && list[i] > list[i + 1]) crntAns++
    }
    return crntAns
}