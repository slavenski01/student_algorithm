package yandex_traning.traning_1.lection1

fun main() {
    val t = readLine()

    val troom = t?.substringBefore(' ')?.toInt() ?: return
    val tcond = t.substringAfter(' ').toInt()

    val mode = readLine() ?: return

    when (mode) {
        "freeze" -> {
            if (troom >= tcond) println(tcond)
            else println(troom)
        }

        "heat" -> {
            if (troom <= tcond) println(tcond)
            else println(troom)
        }

        "auto" -> {
            println(tcond)
        }

        "fan" -> {
            println(troom)
        }

        else -> println(troom)
    }
}