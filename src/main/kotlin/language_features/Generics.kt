package language_features

private interface Source<T> {
    fun next(): T
    fun copy(from: Array<T>, to: Array<T>)
}

private class TestSource<T>(private val value: T) : Source<T> {
    override fun next(): T {
        return value
    }

    override fun copy(from: Array<T>, to: Array<T>) {
        assert(from.size == to.size)
        for (i in from.indices) {
            to[i] = from[i]
        }
    }
}

fun main() {
    val test1 = TestSource("hello")
    println(test1.next())

    val fromArr = arrayOf("one", "two")
    val toArr = arrayOf("three", "four")
    test1.copy(fromArr, toArr)
    println(toArr.toList())
}