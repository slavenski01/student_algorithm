package grokaem_algorithms

import java.util.LinkedList
import java.util.Queue
/*
* slava -----stadion
* |    `-----bridge-----dns
* |                      |
*  `-----cinema----kfc----
* */


fun main() {
    val graph = hashMapOf<String, List<String>>()
    graph["slava"] = listOf("stadion", "bridge", "cinema")
    graph["stadion"] = listOf()
    graph["bridge"] = listOf("dns")
    graph["cinema"] = listOf("kfc")
    graph["kfc"] = listOf("dns")

    val queueSearch: Queue<List<String>> = LinkedList()
    queueSearch.add(graph["slava"])

    while (!queueSearch.isEmpty()) {
        val point = queueSearch.peek()
//        if(point == "dns")
    }
}

