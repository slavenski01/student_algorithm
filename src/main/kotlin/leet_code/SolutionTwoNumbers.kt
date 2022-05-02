package leet_code

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

fun main() {
    val l1 = listOf(2, 4, 3)
    val l2 = listOf(5, 6, 4)
    println("${addTwoNumbers(l1, l2)}")
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: List<Int>?, l2: List<Int>?): List<Int>? {
    if (l1 == null || l2 == null) return null
    val numbl1 = l1.reversed().joinToString(separator = "").toInt()
    val numbl2 = l2.reversed().joinToString(separator = "").toInt()
    println("n1: $numbl1, n2: $numbl2")
    val sum = numbl1 + numbl2
    println("sum: ${sum.toString().toList().reversed()}")
    return sum.toString().toList().reversed().map { it.toString().toInt() }
}
