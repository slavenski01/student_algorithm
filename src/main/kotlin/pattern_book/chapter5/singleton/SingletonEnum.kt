package pattern_book.chapter5.singleton

enum class SingletonEnum {
    UNIQUE_INSTANCE;
    var a = 10
}

fun main() {
    val ui = SingletonEnum.UNIQUE_INSTANCE
    ui.a = 21
    val b = SingletonEnum.UNIQUE_INSTANCE
    print(b.a)
}