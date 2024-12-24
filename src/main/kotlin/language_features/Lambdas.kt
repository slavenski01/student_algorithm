package language_features

fun main() {
    println(solve1("лаапоть", "пальтоо"))
}

fun test(a: String, b: String, res: Boolean) {
    check(solve(a, b) == res) { "Упал тест: a=$a, b=$b, ожидался результат $res" }
}

fun solve(a: String, b: String): Boolean {
    if (a.length != b.length) return false

    val aMap = mutableMapOf<Char, Int>()
    val bMap = mutableMapOf<Char, Int>()

    for (c in a.indices) {
        aMap[a[c]] = ((aMap[a[c]]?: 0) + 1)
        bMap[b[c]] = ((bMap[b[c]]?: 0) + 1)
    }

    val temp = mutableListOf<String>()

    return aMap.toSortedMap() == bMap.toSortedMap()
}

fun solve1(a: String, b: String): Boolean {

    if (a.length != b.length) return false

    val temp = a.toMutableList()

    for (i in 0..b.length - 1) {
        temp.remove(b[i])
    }

    return temp.isEmpty()
}