package leet_code

class Solution {
    var li = ListNode(5)
    var v = li.`val`

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var nextL1 = l1
        var nextL2 = l2
        var resultL = ListNode(0)
        var isNeedAddOne = false

        while (nextL1 != null && nextL2 != null) {
            val currentSum = nextL1.`val` + nextL2.`val` + if(isNeedAddOne) 1 else 0

            if(currentSum > 9) {
                isNeedAddOne = true
                resultL.`val` = currentSum % 10
            } else {
                isNeedAddOne = false
                resultL.`val` = currentSum
            }

            nextL1 = nextL1.next
            nextL2 = nextL2.next
        }

        when {
            nextL1 == null && nextL2 != null -> {
                while(nextL2 != null) {
                    if(isNeedAddOne) {
                        val tempSum = nextL2.`val` + 1
                        if(tempSum > 9) resultL.`val` = tempSum % 10
                        else resultL.`val` = tempSum
                    }
                    nextL2 = nextL2.next
                }
            }
        }

        return ListNode(0)
    }

    fun test() {

    }
}

fun main() {

}