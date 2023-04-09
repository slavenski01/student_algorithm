package leet_code.hashmap

class SuperHashMap {
    private val superArr = Array<String?>(16) {
        null
    }

    fun put(key: Int, value: String) {
        if(key >= superArr.size ) throw IllegalStateException("Array index out of bounds")

        superArr[key] = value
    }

    fun get(key: Int): String? {
        if(key >= superArr.size ) return null
        return superArr[key]
    }
}