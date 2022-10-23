package leet_code

//https://leetcode.com/problems/contains-duplicate-ii/

fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7,8,9,9)
    println(containsNearbyDuplicate(nums, k = 3))
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val lastIndexes = HashMap<Int, Int>(13 * (nums.size + 7))

    for (i in nums.indices) {
        val lastIndex = lastIndexes[nums[i]]
        if (lastIndex != null && i - lastIndex <= k) return true
        lastIndexes[nums[i]] = i
    }

    return false
}