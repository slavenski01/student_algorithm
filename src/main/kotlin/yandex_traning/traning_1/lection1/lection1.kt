package yandex_traning.traning_1.lection1

fun main() {
    println(getMustSymbol2("ababa"))
    println(getMustSymbol3("ababa"))
}

fun getMustSymbol2(s: String): Char {
    var anscnt = 0
    var ans = ' '

    s.toSet().forEach { char ->
        var currentCnt = 0
        s.forEach {
            if (char == it) currentCnt++
            if (currentCnt > anscnt) {
                anscnt = currentCnt
                ans = char
            }
        }
    }

    return ans
}

fun getMustSymbol3(s: String): Char {
    val sMap = mutableMapOf<Char, Int>()

    s.forEach {
        if (sMap[it] != null) sMap[it]?.plus(1)
        else sMap[it] = 1
    }
    return sMap.maxByOrNull { it.value }?.key ?: ' '
}