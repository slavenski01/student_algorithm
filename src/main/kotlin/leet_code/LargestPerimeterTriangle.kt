package leet_code

fun main() {
    println(largestPerimeter(intArrayOf(1, 2, 2)))
}

fun largestPerimeter(nums: IntArray): Int {
    val sortedArray = nums.sortedArray()

    for (i in sortedArray.size - 3 downTo 0 step 1) {
        if (sortedArray[i] + sortedArray[i + 1] > sortedArray[i + 2])
            return sortedArray[i] + sortedArray[i + 1] + sortedArray[i + 2]
    }
    return 0
}