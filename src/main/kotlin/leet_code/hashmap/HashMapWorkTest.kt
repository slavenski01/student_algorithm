package leet_code.hashmap

fun main() {
    val superMap = SuperHashMap()
    superMap.put(1, "first")
    superMap.put(2, "second")

    println("key 1 = ${superMap.get(1)}")
    println("key 2 = ${superMap.get(2)}")
    println("key 3 = ${superMap.get(3)}")

    val key1 = Key("Hello")
    val key2 = Key("Vlg")
    val key3 = Key("Msk")
    val key4 = Key("Slava")

    println("key1 hash: ${key1.hashCode()}")
}