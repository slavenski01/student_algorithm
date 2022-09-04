package leet_code

fun main() {
    println(isSubsequence(s = "abc", t = "ahbgdc"))
    println(isSubsequence(s = "axc", t = "ahbgdc"))
    println(isSubsequence(s = "", "ahbgdc"))
    println(isSubsequence("b", "abc"))
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    var indexTry = 0
    for (i in t) {
        if (indexTry >= s.length) return true
        if (i == s[indexTry]) {
            indexTry++
        }
    }
    return s.length == indexTry
}