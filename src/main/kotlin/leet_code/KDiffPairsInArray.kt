package leet_code

//https://leetcode.com/problems/k-diff-pairs-in-an-array/
fun main() {
    val intArray = intArrayOf(1, 3, 1, 5, 4)
    val k = 0
    println(findPairs(nums = intArray, k = k))
}

fun findPairs(nums: IntArray, k: Int): Int {
    val listPair = mutableListOf<Pair<Int, Int>>()
    nums.forEachIndexed { i, mainN ->
        nums.forEachIndexed {j, subN ->
            if(i != j) {
                if (Math.abs(subN - mainN) == k) {
                    if(listPair.find { it.first + it.second == mainN + subN } == null) {
                        listPair.add(Pair(mainN, subN))
                    }
                }
            }
        }
    }
    return listPair.size
}