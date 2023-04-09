package leet_code

import java.util.*

fun main() {
    minWindow(s = "ADOBECODEBANC", t = "ABC")
}

fun minWindow(s: String, t: String): String {
    val firstT = t[0]
    val arrayS = s.toCharArray()

    val indexesAnother = HashMap<Char, Int?>()
    for (char in t.removeRange(0..0).toCharArray()) {
        indexesAnother[char] = null
    }

    println("array: $arrayS, firstT: $firstT")

    for (i in arrayS.indices) {
        if (indexesAnother[arrayS[i]] == null) {
            indexesAnother[arrayS[i]] = i
        } else {

        }
    }
    return ""
}