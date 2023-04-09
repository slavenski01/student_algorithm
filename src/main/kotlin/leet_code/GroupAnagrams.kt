package leet_code

/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the
 * letters of a different word or phrase, typically using
 * all the original letters exactly once.
 * */

fun main() {
    println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val resultMap = mutableMapOf<String, MutableList<String>>()
    strs.forEach {
        val sortedString = it.toCharArray().sorted().toString()
        if (resultMap[sortedString] == null) {
            resultMap[sortedString] = mutableListOf(it)
        } else {
            resultMap[sortedString]?.add(it)
        }
    }
    val resultList = mutableListOf<List<String>>()
    resultMap.forEach {
        resultList.add(it.value)
    }
    return resultList
}