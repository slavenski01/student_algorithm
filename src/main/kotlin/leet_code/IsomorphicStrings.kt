package leet_code

fun main() {
    println(isIsomorphic(s = "foo", t = "bar"))
    println(isIsomorphic(s = "egg", t = "add"))
    println(isIsomorphic(s = "paper", t = "title"))
    println(isIsomorphic(s = "badc", t = "baba"))
}

fun isIsomorphic(s: String, t: String): Boolean {
    val tempMap = mutableMapOf<Char, Char>()
    val sChars = s.toCharArray()
    val tChars = t.toCharArray()

    for (i in sChars.indices) {
        if (tempMap[sChars[i]] == null) {
            if(tempMap.values.contains(t[i])) return false
            tempMap[sChars[i]] = tChars[i]
            sChars[i] = tChars[i]
        } else {
            sChars[i] = tempMap[sChars[i]]!!
        }
    }
    return sChars.contentEquals(tChars)
}