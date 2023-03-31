package leet_code

import java.util.*
import kotlin.math.min

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */

fun main() {
    val list1: ListNode = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(5)
        }
    }

    val list2 = ListNode(1).apply {
        next = ListNode(7).apply {
            next = ListNode(8)
        }
    }

    val list3 = ListNode(2).apply {
        next = ListNode(6)
    }

    val lists = arrayOf<ListNode?>(list1, list2, list3)

    mergeKLists(lists)?.printList()
}

fun ListNode.printList() {
    var currentItem: ListNode? = this
    while (currentItem != null) {
        print("${currentItem.`val`} - ")
        currentItem = currentItem.next
    }
    println()
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val k = lists.size + 1
    val minHeap = PriorityQueue<ListNode>(k, compareBy { it.`val` })
    lists.forEach { headNode ->
        if (headNode != null) minHeap.offer(headNode)
    }
    println("minHeap")
    minHeap.forEach {
        it.printList()
    }
    var result: ListNode? = null
    var resultBuilder = result
    while (minHeap.size > 0) {
        val nextNode = minHeap.poll()
        println("nextNode: ${nextNode.`val`}")
        if (result == null) {
            result = nextNode
            resultBuilder = nextNode
        } else {
            resultBuilder!!.next = nextNode
            resultBuilder = nextNode
        }
        if (nextNode.next != null) {
            minHeap.offer(nextNode.next)
        }
    }

    return result
}