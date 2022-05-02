package pattern_book.chapter1.duck

interface FlyBehavior {
    fun fly()
}

class FlyWithWings: FlyBehavior {
    override fun fly() {
        println("flying")
    }
}

class FlyNoWay: FlyBehavior {
    override fun fly() {
        println("not flying")
    }
}