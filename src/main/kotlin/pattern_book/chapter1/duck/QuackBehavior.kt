package pattern_book.chapter1.duck

interface QuackBehavior {
    fun quack()
}

class Quack: QuackBehavior {
    override fun quack() {
        println("quaaa")
    }
}

class Squeak: QuackBehavior {
    override fun quack() {
        println("pipipi")
    }
}

class MuteQuack: QuackBehavior {
    override fun quack() {
        println("...")
    }
}