package pattern_book.chapter5.singleton

class Singleton private constructor() {
    companion object {
        private var uniqueInstance: Singleton? = null
        fun getInstance(): Singleton? {
            if(uniqueInstance == null) {
                uniqueInstance = Singleton()
            }
            return uniqueInstance
        }
    }

    var a = 10
    get() {
        return field + 10
    }
}

fun main() {
    val a = Singleton.getInstance()
    a?.a = 20
    val b = Singleton.getInstance()
    println(b?.a)
}

