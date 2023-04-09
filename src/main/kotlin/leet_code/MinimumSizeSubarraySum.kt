package leet_code

import kotlin.math.min

//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//завести мапу вида (i, {7 - array[i]})
//

fun main() {
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var sum = 0
    var left = 0
    var ans = Int.MAX_VALUE
    for (i in nums.indices) {
        sum += nums[i]
        while (sum >= target) {
            ans = min(ans, i + 1 - left)
            sum -= nums[left++]
        }
    }
    return if (ans != Int.MAX_VALUE) ans else 0
}