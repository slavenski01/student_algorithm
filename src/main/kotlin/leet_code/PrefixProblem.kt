package leet_code

//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.

fun main() {
    println("1. " + findCommonPrefix(listOf("flower", "flow", "flight")))
    println("2. " + findCommonPrefix(listOf("dogcar", "racecar", "car")))
//    println(findCommonPrefixOnTwoString("flo", "flow"))
//    println(findCommonPrefixOnTwoString("erfl", "floweer"))
}

private fun findCommonPrefix(strings: List<String>): String {
    var commonPrefix = ""
    val sortedString = strings.sortedBy { it.length }

    for (i in 0..(sortedString.size - 2)) {
        val prefixCurrent = findCommonPrefixOnTwoString(sortedString[i], sortedString[i + 1])
        if (prefixCurrent == "") {
            return ""
        } else {
            commonPrefix = findCommonPrefixOnTwoString(sortedString[i], sortedString[i + 1])
        }
    }

    return commonPrefix
}

private fun findCommonPrefixOnTwoString(first: String, second: String): String {
    var commonSubString = ""

    first.forEachIndexed { index, c ->
        var firstIndex = index
        var secondIndex = 0
        var tempCommonPrefix = ""

        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] == second[secondIndex]) {
                tempCommonPrefix += first[firstIndex]
                firstIndex++
                secondIndex++
            } else {
                secondIndex++
            }
        }

        if (tempCommonPrefix.length > commonSubString.length) {
            commonSubString = tempCommonPrefix
        }
    }
    return commonSubString
}