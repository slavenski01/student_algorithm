package yandex_traning.traning_1.lection2

/**
 * Дан список. Определите, является ли он монотонно возрастающим
 * (то есть верно ли, что каждый элемент этого списка больше предыдущего).
 * Выведите YES, если массив монотонно возрастает и NO в противном случае.
 *
 *
 **/
fun main() {
    val strIn = readLine() ?: return
    val list: List<Int> = strIn.split(" ").map { it.toInt() }

    if (h1Solution(list)) println("YES") else println("NO")
}

private fun h1Solution(list: List<Int>): Boolean {
    for (i in 0..list.size - 2) {
        if (list[i] >= list[i + 1]) {
            return false
        }
    }
    return true
}