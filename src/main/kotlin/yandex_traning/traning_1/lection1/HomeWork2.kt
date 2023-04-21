package yandex_traning.traning_1.lection1

fun main() {
    val a = readLine()?.toInt() ?: return
    val b = readLine()?.toInt() ?: return
    val c = readLine()?.toInt() ?: return

    if(a + b > c && a + c > b && b + c > a) println("YES") else println("NO")
}