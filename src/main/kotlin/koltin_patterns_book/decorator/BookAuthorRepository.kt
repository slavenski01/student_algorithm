package koltin_patterns_book.decorator

fun main() {
    val bookAuthorRepository = BookAuthorRepository()
    val loggingGetAuthor = LoggingGetAuthor(bookAuthorRepository)
    val validateNameGetAuthor = ValidateNameGetAuthor(bookAuthorRepository)

    println(loggingGetAuthor["PUSHKIN"])
    validateNameGetAuthor["GORE OT UMA"] = "GRIBOEDOV"
    println(loggingGetAuthor["GRIBOEDOV"])
}

private interface BookAuthorRepo {
    operator fun get(author: String): String
    operator fun set(author: String, book: String)
}

private class BookAuthorRepository : BookAuthorRepo {
    private val bookAuthor = mutableMapOf("PUSHKIN" to "CAPTAIN DOCHKA")

    override fun get(author: String): String {
        return bookAuthor[author] ?: "Unknown"
    }

    override fun set(author: String, book: String) {
        bookAuthor[book] = author
    }
}

private class LoggingGetAuthor(private val bookAuthorRepo: BookAuthorRepo) : BookAuthorRepo by bookAuthorRepo {
    override fun get(author: String): String {
        println("author: $author")
        return bookAuthorRepo[author]
    }
}

private class ValidateNameGetAuthor(private val bookAuthorRepo: BookAuthorRepo) : BookAuthorRepo by bookAuthorRepo {
    override fun set(author: String, book: String) {
        if (author.length > 15) {
            println("too many length")
        } else {
            bookAuthorRepo[author] = book
        }
    }
}