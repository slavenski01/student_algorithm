package leet_code

fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    println(search(intArrayOf(5), 5))
}

fun search(nums: IntArray, target: Int): Int {
    var startIndex = 0
    var endIndex = nums.size - 1
    while (startIndex <= endIndex) {
        val midIndex: Int = (endIndex + startIndex) / 2
        if (target == nums[midIndex]) return midIndex
        if (target > nums[midIndex]) {
            startIndex = midIndex + 1
        } else if (target < nums[midIndex]) {
            endIndex = midIndex - 1
        }
    }
    return -1
}