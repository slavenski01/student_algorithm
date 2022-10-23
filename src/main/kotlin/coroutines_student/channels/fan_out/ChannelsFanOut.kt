package coroutines_student.channels.fan_out

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

typealias Predicate<E> = (E) -> Boolean
typealias Rule<E> = Pair<Channel<E>, Predicate<E>>

enum class Sex {
    MAN, WOMAN
}

const val WHITE = "WHITE"
const val BLACK = "BLACK"

interface Item {
    val name: String
    val sex: Sex
    val colorHair: String
}

data class People(
    override val name: String,
    override val colorHair: String,
    override val sex: Sex
) : Item

fun main() {
    fun produceItem(): ArrayList<Item> = arrayListOf(
        People(name = "Slava", colorHair = BLACK, sex = Sex.MAN),
        People(name = "Anastasiya", colorHair = BLACK, sex = Sex.WOMAN),
        People(name = "Roma", colorHair = BLACK, sex = Sex.MAN),
        People(name = "Ekaterina", colorHair = WHITE, sex = Sex.WOMAN),
        People(name = "Vladislav", colorHair = BLACK, sex = Sex.MAN),
        People(name = "Aliya", colorHair = WHITE, sex = Sex.WOMAN),
        People(name = "Viktoriya", colorHair = BLACK, sex = Sex.WOMAN),
        People(name = "Dmitriy", colorHair = BLACK, sex = Sex.MAN),
    )

    runBlocking {
        val mainChannel = Channel<Item>()

        val manBlackChannel = Channel<Item>()
        val womanWhiteChannel = Channel<Item>()

        launch {
            produceItem().forEach {
                mainChannel.send(it)
            }
            mainChannel.close()
        }

        val typeDemuplexer = Demultiplexer(
            manBlackChannel to { item: Item -> item.sex == Sex.MAN && item.colorHair == BLACK },
            womanWhiteChannel to { item: Item -> item.sex == Sex.WOMAN && item.colorHair == WHITE }
        )

        launch {
            typeDemuplexer.consume(mainChannel)
        }

        launch {
            manBlackChannel.consumeEach {
                println("${it.name}, color hair: ${it.colorHair}")
            }
        }

        launch {
            womanWhiteChannel.consumeEach {
                println("${it.name}, color hair: ${it.colorHair}")
            }
        }
    }
}