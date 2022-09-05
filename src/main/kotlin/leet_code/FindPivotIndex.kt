package leet_code

fun main() {
    println(pivotIndex(intArrayOf(2,1,-1)))
}

fun pivotIndex(nums: IntArray): Int {
    val rightSum = nums.sum()
    if (rightSum - nums[0] == 0) return 0
    var leftSum = 0

    for (i in 1 until nums.size) {
        leftSum += nums[i - 1]
        val rightCurrentSum = rightSum - nums[i] - leftSum
        println("left: $leftSum, right: $rightCurrentSum")
        if (leftSum == rightCurrentSum) return i
    }
    return -1
}