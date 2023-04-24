package yandex_traning.traning_1.lection1

/**
 *  ______
 * /ax + b = c
 * решить в целых числах, либо вывести, что корней бесконечно много
 * ax + b = c^2
 * проверить корни есть у с
 *
 * NO SOLUTION - нет решений
 * MANY SOLUTIONS - решений бесконечно много
 * */

fun main() {
    val a = readLine()?.toInt() ?: return
    val b = readLine()?.toInt() ?: return
    val c = readLine()?.toInt() ?: return

    println(solution(a, b, c))
}

fun solution(a: Int, b: Int, c: Int): String {

    if (c < 0) return "NO SOLUTION"

    if (c == 0) {
        return if (a != 0) {
            if (b == 0) return "0"
            if (b % a == 0) {
                (-b / a).toString()
            } else {
                "NO SOLUTION"
            }
        } else {
            if (b != 0) {
                "NO SOLUTION"
            } else {
                "MANY SOLUTIONS"
            }
        }
    }

    if (a == 0) {
        return if (c * c == b) "MANY SOLUTIONS"
        else "NO SOLUTION"
    }

    return if ((c * c - b) % a == 0) {
        ((c * c - b) / a).toString()
    } else {
        "NO SOLUTION"
    }
}