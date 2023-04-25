package yandex_traning.traning_1.lection1

/**
 * Бригада скорой помощи выехала по вызову в один из отделенных районов.
 * К сожалению, когда диспетчер получил вызов,
 * он успел записать только адрес дома и номер квартиры K1,
 * а затем связь прервалась. Однако он вспомнил,
 * что по этому же адресу дома некоторое время назад скорая помощь выезжала в квартиру K2,
 * которая расположена в подъезда P2 на этаже N2.
 * Известно, что в доме M этажей и количество квартир на каждой лестничной площадке одинаково.
 * Напишите программу, которая вычилсяет номер подъезда P1 и номер этажа N1 квартиры K1.*/

/***
 *Формат ввода
Во входном файле записаны пять положительных целых чисел K1, M, K2, P2, N2. Все числа не превосходят 106.

Формат вывода
Выведите два числа P1 и N1. Если входные данные не позволяют однозначно определить P1 или N1,
вместо соответствующего числа напечатайте 0.
Если входные данные противоречивы, напечатайте два числа –1 (минус один).
 */

fun main() {
    val string = readLine() ?: return
    val list = string.split(" ")
    val k1 = list[0].toInt()
    val m = list[1].toInt()
    val k2 = list[2].toInt()
    val p2 = list[3].toInt()
    val n2 = list[4].toInt()

    println(solution(k1, m, k2, p2, n2))
}

fun solution(k1: Int, m: Int, k2: Int, p2: Int, n2: Int): String {

    if (p2 == 1 && k2 == 1 && n2 == 1) return "0 1"

    if (k2 < p2 || k2 < n2) return "-1 -1"

    if (k2 < m * p2) return "-1 -1"

    if (k2 / (m * (p2 - 1) + n2) < 1) return "-1 -1"

    if (m * (p2 - 1) + n2 <= 0) return "-1 -1"

    val roomsCnt = if (k2 % (m * (p2 - 1) + n2) == 0) {
        k2 / (m * (p2 - 1) + n2)
    } else {
        (k2 / (m * (p2 - 1) + n2)) + 1
    }

    if (k2 > k1) {
        if (k2 / roomsCnt < k1 / roomsCnt) return "-1 -1"
    } else {
        if (k2 / roomsCnt > k1 / roomsCnt) return "-1 -1"
    }

    val pAns = if ((k1 / roomsCnt) % m == 0) {
        (k1 / roomsCnt) / m
    } else {
        ((k1 / roomsCnt) / m) + 1
    }

    val nAns = if (k1 % roomsCnt == 0) {
        (k1 / roomsCnt) - ((pAns - 1) * m)
    } else {
        (k1 / roomsCnt) - ((pAns - 1) * m) + 1
    }

    return "$pAns $nAns"
}