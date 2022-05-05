package pattern_book.iterator

class SpbMenu {
    private val menuItems: Array<MenuItem?> = arrayOf(
        null, null, null, null, null, null
    )
    private var numberItemsInMenu = 0

    fun addItem(menuItem: MenuItem) {
        if (numberItemsInMenu < MAX_ITEMS) {
            menuItems[numberItemsInMenu] = menuItem
            numberItemsInMenu++
        } else {
            println("menu is full!")
        }
    }

    companion object {
        private const val MAX_ITEMS = 6
    }
}