package koltin_patterns_book

class SingletonPattern private constructor() {
    companion object {
        private var instance: SingletonPattern? = null
        fun create(): SingletonPattern {
            if (instance == null) instance = SingletonPattern()
            return instance!!
        }
    }
}

object SingletonObject {
    init {
        println("init singleton object")
    }
}

fun main() {
    val singletonPattern1 = SingletonPattern.create()
    val singletonPattern2 = SingletonPattern.create()
    println(singletonPattern1 === singletonPattern2)

    val singletonObject = SingletonObject
    val singletonObject2 = SingletonObject
    println(singletonObject === singletonObject2)
}