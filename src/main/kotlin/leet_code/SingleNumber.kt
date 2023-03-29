package leet_code

//[4, 2, 1, 2, 1]
//Дан массив чисел, вывести элемент, который не встречается дважды за O(1) по памяти

//1. массив размера нечетного числа
//2.

fun main() {
    println(singleNumber(intArrayOf(4, 2, 1, 2, 1)))
}

fun singleNumber(nums: IntArray): Int {
    return nums.reduce { prev, current -> prev xor current }
}