package leet_code

fun main() {
    val intArray = intArrayOf(1, 2, 3, 4)
    runningSum(intArray)
    intArray.forEach {
        print("$it, ")
    }
}

fun runningSum(nums: IntArray): IntArray {
    var sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        nums[i] = sum
    }
    return nums
}