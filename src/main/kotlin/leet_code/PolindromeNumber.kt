package leet_code

fun main() {
    println(isPalindrome(121))
    println(isPalindrome(123))
    println(isPalindrome(11111))
    println(isPalindrome(11))
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    val stringX = x.toString()
    for(i in stringX.indices) {
        if(stringX[i] != stringX[stringX.length - 1 - i]) return false
    }
    return true
}