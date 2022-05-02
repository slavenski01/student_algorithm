package leet_code

//https://leetcode.com/problems/first-bad-version/
fun main() {
    println(firstBadVersion(100))
}

private fun isBadVersion(version: Int): Boolean {
    return version == 40
}

fun firstBadVersion(n: Int): Int = firstBadVersion(n, 1, n)

private tailrec fun firstBadVersion(n: Int, left: Int, right: Int): Int =
    when {
        left > right -> 0
        else -> {
            val middle = left + (right - left) / 2
            when {
                !isBadVersion(middle) ->
                    firstBadVersion(n, middle + 1, right)
                middle > 1 && isBadVersion(middle - 1) ->
                    firstBadVersion(n, left, middle - 1)
                else -> middle
            }
        }
    }