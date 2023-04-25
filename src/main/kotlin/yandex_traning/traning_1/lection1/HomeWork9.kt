package yandex_traning.traning_1.lection1

/**
 * За многие годы заточения узник замка Иф
 * проделал в стене прямоугольное отверстие размером D × E.
 * Замок Иф сложен из кирпичей, размером A × B × C.
 * Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие,
 * если стороны кирпича должны быть параллельны сторонам отверстия.
 * Формат ввода
 * Программа получает на вход числа A, B, C, D, E.
 *
 * Формат вывода
 * Программа должна вывести слово YES или NO.
 *
 **/
fun main() {
    var a = readLine()?.toInt() ?: return
    var b = readLine()?.toInt() ?: return
    var c = readLine()?.toInt() ?: return
    var d = readLine()?.toInt() ?: return
    var e = readLine()?.toInt() ?: return

    if (d > e) {
        d += e
        e = d - e
        d -= e
    }

    val list = mutableListOf(a, b, c)
    for (i in 0..2) {
        for (j in 0..2) {
            if (list[i] < list[j]) {
                val temp = list[j]
                list[j] = list[i]
                list[i] = temp
            }
        }
    }
    a = list[0]
    b = list[1]
    c = list[2]
    println("$a, $b, $c, $d, $e")
    println(ifSolution(a, b, c, d, e))
}

private fun ifSolution(a: Int, b: Int, c: Int, d: Int, e: Int): String {
    var ans: String = "NO"
    ans = if (a <= d && b <= e) "YES" else "NO"
    return ans
}