package pattern_book.iterator

class VlgMenu() {
    private val menuItems: ArrayList<MenuItem> = arrayListOf()

    init {
        menuItems.add(MenuItem(name = "test1", isVegetarian = false))
        menuItems.add(MenuItem(name = "test2", isVegetarian = true))
        menuItems.add(MenuItem(name = "test3", isVegetarian = false))
        menuItems.add(MenuItem(name = "test4", isVegetarian = true))
    }

    fun createIterator()  = menuItems.iterator()

    fun addItem(menuItem: MenuItem) {
        menuItems.add(menuItem)
    }

    fun removeItem(menuItem: MenuItem) {
        menuItems.remove(menuItem)
    }
}