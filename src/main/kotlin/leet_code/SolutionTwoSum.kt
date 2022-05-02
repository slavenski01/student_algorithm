package leet_code

fun main() {
    val numbers1 = intArrayOf(-1,-2,-3,-4,-5)
    println("${twoSum(numbers1, target = -8).toList()}")
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        if (Math.abs(nums[i]) > Math.abs(target)) continue
        var j = 0
        while (j < nums.size - 1) {
            if(i == j) {
                j++
                continue
            }
            if (nums[j] + nums[i] == target) return intArrayOf(i, j)
            j++
        }
    }
    return intArrayOf(0, 0)
}