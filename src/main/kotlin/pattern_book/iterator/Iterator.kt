package pattern_book.iterator

interface Iterator {
    fun hasNext(): Boolean
    fun getNext(): MenuItem
}