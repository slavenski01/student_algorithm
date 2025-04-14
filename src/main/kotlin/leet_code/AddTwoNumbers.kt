package leet_code

import leet_code.Solution.Companion.print
import kotlin.math.max


private class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null || l2 == null) return null

        if (l1.`val` == 0) return l2
        if (l2.`val` == 0) return l1

        var ost = 0
        val steps = max(l1.getSize(l1), l2.getSize(l2))

        val resultList = ListNode(l1.getNode(0).`val` + l2.getNode(0).`val`)

        for (i in 1 until steps) {
            resultList.addNode(ListNode(l1.getNode(i).`val` + l2.getNode(i).`val`))
        }

        return resultList
    }

    companion object {
        fun ListNode.getSize(l1: ListNode, size: Int = 0): Int {
            return if (l1.next == null) size + 1 else getSize(
                l1 = l1.next ?: throw IllegalArgumentException("getSize"),
                size = size + 1
            )
        }

        fun ListNode.getNode(index: Int, currentIndex: Int = 0): ListNode {
            return if (index == currentIndex) {
                this
            } else {
                this.next?.getNode(index, currentIndex + 1) ?: throw IllegalArgumentException("get node null")
            }
        }

        fun ListNode.addNode(node: ListNode) {
            this.getLast().next = node
        }

        fun ListNode.getLast(): ListNode {
            return if (this.next == null) this else this.next?.getLast()
                ?: throw IllegalArgumentException("getLast null")
        }

        fun ListNode.print() {
            return if (this.next != null) {
                this.next?.print() ?: throw IllegalArgumentException("getLast null")
            } else {
                println(this.`val`)
            }
        }
    }
}

fun main() {
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }
    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }
    println(Solution().addTwoNumbers(l1, l2)?.print())
}