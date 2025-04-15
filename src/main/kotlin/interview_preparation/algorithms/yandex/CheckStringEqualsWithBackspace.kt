package interview_preparation.algorithms.yandex

/**
 * Проверить равны ли строки с учетом операций backspace (#)
 * Без использования дополнительной памяти
 *
 * Временная сложность: O(n), где n - максимальная длина строк
 * Пространственная сложность: O(1)
 */

fun main() {
    println(backspaceCompare("ab#c", "ad#c")) // true
    println(backspaceCompare("ab##", "c#d#")) // true
    println(backspaceCompare("a#c", "b")) // false
    println(backspaceCompare("######abc", "#abc")) // true
}

//Не оптимальное решение
fun backspaceCompareNonOptimal(s1: String, s2: String): Boolean {
    var skip1 = 0
    var skip2 = 0

    var cursor1 = s1.lastIndex
    var cursor2 = s2.lastIndex

    var str1 = ""
    var str2 = ""

    while (cursor1 >= 0) {
        if (s1[cursor1] == '#') {
            skip1++
        } else {
            cursor1 -= skip1
            if (cursor1 >= 0 && s1[cursor1] != '#') str1 += s1[cursor1]
        }
        cursor1--
    }

    while (cursor2 >= 0) {
        if (s2[cursor2] == '#') {
            skip2++
        } else {
            cursor2 -= skip2
            if (cursor2 >= 0 && s2[cursor2] != '#') str2 += s2[cursor2]
        }
        cursor2--
    }

    return str1 == str2
}

fun backspaceCompare(s1: String, s2: String): Boolean {
    var i = s1.lastIndex
    var j = s2.lastIndex
    var skip1 = 0
    var skip2 = 0

    while (i >= 0 || j >= 0) {
        // Пропускаем удаленные символы в первой строке
        while (i >= 0) {
            if (s1[i] == '#') {
                skip1++
                i--
            } else if (skip1 > 0) {
                skip1--
                i--
            } else {
                break
            }
        }

        // Пропускаем удаленные символы во второй строке
        while (j >= 0) {
            if (s2[j] == '#') {
                skip2++
                j--
            } else if (skip2 > 0) {
                skip2--
                j--
            } else {
                break
            }
        }

        // Сравниваем текущие символы
        if ((i >= 0) != (j >= 0)) return false
        if (i >= 0 && s1[i] != s2[j]) return false

        i--
        j--
    }

    return true
}