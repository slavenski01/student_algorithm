package language_features

fun main() {
    lock(
        fooInline = { println("foo") },
        fooNoInline = { println("noinline") }
    )

    println(getAllMembers<StringBuilder>())
}

inline fun lock(
    fooInline: () -> Unit,
    noinline fooNoInline: () -> Unit
) {
    fooInline()
    fooNoInline()
    println("lock")
}

inline fun f(crossinline block: () -> Unit) {
    val o = Runnable { block() }
}

inline fun <reified T> getAllMembers() = T::class.members.joinToString("\n")