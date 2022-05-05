package pattern_book.iterator

fun main() {
    val vlgMenu = VlgMenu()
    val iteratorVlg = vlgMenu.createIterator()
    println("item1: ${iteratorVlg.next()}")
    println("item2: ${iteratorVlg.next()}")
    println("item3: ${iteratorVlg.next()}")
    println("item4: ${iteratorVlg.next()}")
}