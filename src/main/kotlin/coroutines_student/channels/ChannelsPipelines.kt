package coroutines_student.channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

interface Item {
    val name: String
    val color: String
}

data class Animal(
    override val name: String,
    override val color: String
) : Item

data class Plant(
    override val name: String,
    override val color: String
) : Item

const val WHITE = "White"

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    fun isAnimal(item: Item) = item is Animal
    fun isWhite(item: Item) = item.color == WHITE

    fun produceItems() = GlobalScope.produce {
        val items = arrayListOf(
            Animal(name = "Lion", color = "Orange"),
            Animal(name = "Tiger", color = "Red"),
            Animal(name = "WhiteBear", color = WHITE),
            Animal(name = "Dog", color = WHITE),
            Plant(name = "Rose", color = "Red"),
            Plant(name = "Gvozdika", color = "Yellow"),
            Plant(name = "Pion", color = WHITE),
            Plant(name = "Landishi", color = "Blue"),
        )
        items.forEach {
            send(it)
        }
    }

    fun isAnimal(items: ReceiveChannel<Item>) = GlobalScope.produce {
        for(item in items) {
            if(isAnimal(item)) send(item)
        }
    }

    fun isWhite(items: ReceiveChannel<Item>) = GlobalScope.produce {
        for(item in items) {
            if(isWhite(item)) send(item)
        }
    }

    runBlocking {
        val itemsChannel = produceItems()
        val animalChannel = isAnimal(itemsChannel)
        val whiteAnimalChannel = isWhite(animalChannel)

        for(item in whiteAnimalChannel) {
            println(item)
        }

        itemsChannel.cancel()
        animalChannel.cancel()
        whiteAnimalChannel.cancel()

        println("Done")
    }
}