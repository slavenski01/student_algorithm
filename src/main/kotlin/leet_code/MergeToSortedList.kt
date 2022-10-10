package leet_code

fun main() {
    val list1 = ListNode(1)
        .apply {
            next = ListNode(2).apply {
                next = ListNode(4)
            }
        }
    val list2 = ListNode(1)
        .apply {
            next = ListNode(5).apply {
                next = ListNode(4)
            }
        }

    mergeTwoLists(list1, list2)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

    if (list1 == null) return list2
    else if (list2 == null) return list1

    var listA: ListNode? = list1
    var listB: ListNode? = list2

    val head: ListNode
    if (listA!!.`val` < listB!!.`val`) {
        head = listA
        listA = listA.next
    } else {
        head = listB
        listB = listB.next
    }

    var node: ListNode? = head
    while (listA != null || listB != null) {
        when {
            listA == null -> {
                node?.next = listB
                listB = null
            }

            listB == null -> {
                node?.next = listA
                listA = null
            }

            else -> {
                if (listA.`val` < listB.`val`) {
                    node?.next = listA
                    listA = listA.next
                } else {
                    node?.next = listB
                    listB = listB.next
                }
            }
        }

        node = node?.next
    }

    return head
}