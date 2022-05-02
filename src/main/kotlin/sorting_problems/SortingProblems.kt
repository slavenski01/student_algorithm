package sorting_problems

fun main(args: Array<String>) {
    println("${insertionSort(arrayOf(12, 31, 52, 34, 666, 666, 1, 223)).toList()}")
}

fun insertionSort(inputArray: Array<Int>): Array<Int> {
    for (i in inputArray.indices) {
        var j = 0
        var temp = 0
        while (j < inputArray.size - 1) {
            if (inputArray[j] > inputArray[i]) {
                temp = inputArray[i]
                inputArray[i] = inputArray[j]
                inputArray[j] = temp
            }
            j++
        }
    }
    return inputArray
}