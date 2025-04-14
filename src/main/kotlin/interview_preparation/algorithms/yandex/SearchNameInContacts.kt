package interview_preparation.algorithms.yandex

//Мы хотим вызвать такси своему другу.
//Для этого нужно реализовать нечёткий поиск по списку контактов пользователя.
//
//Условия задачи:
//
//Входные данные: строка поиска (input) и список контактов (dataSet).
//Нужно найти в списке контактов такие строки, которые максимально похожи на строку поиска.
//Похожесть определяется на основе частичного совпадения символов и подстрок (нечёткий поиск).
//
//Примеры:
//
//Контакты: "John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson"
//Ищем: "Joh"
//Результат: ["John Smith", "Mark Johnson"]
//
//Контакты: "John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson"
//Ищем: "m John"
//Результат: ["Mark Johnson"]
//
//Контакты: "John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson", "Kamil Englo", "Mjohn Kengsman", "Mjohn Keng"
//Ищем: "keng"
//Результат: ["Kamil Englo", "Mjohn Kengsman", "Mjohn Keng"]

fun main() {
    println(
        "non Optimal: " +
                predictNonOptimal(
                    input = "Joh",
                    dataSet = listOf("John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson")
                )
    )
    println(
        "Optimal: " +
                predictOptimal(
                    input = "keng",
                    dataSet = listOf(
                        "John Smith",
                        "Mike Marley",
                        "Hillary Cosplay",
                        "Mark Johnson",
                        "Kamil Englo",
                        "Mjohn Kengsman",
                        "Mjohn Keng"
                    )
                )
    )
}

// Неоптимальное решение
private fun predictNonOptimal(input: String, dataSet: List<String>): List<String> {
    val searchWords = input.lowercase().split(" ").filter { it.isNotBlank() }
    return dataSet.filter { contact ->
        val contactLower = contact.lowercase()
        searchWords.all { word -> word in contactLower }
    }
}

private fun predictOptimal(input: String, dataSet: List<String>): List<String> {
    val searchString = input.lowercase().filter { it != ' ' }
    println("searchString: $searchString")

    return dataSet.filter { contact ->
        val contactLower = contact.lowercase()
        if (contactLower.length >= searchString.length) {
            var successPosition = 0
            contactLower.forEach { char ->
                if (successPosition < searchString.length) {
                    if (char == searchString[successPosition]) {
                        successPosition++
                    }
                }
            }
            successPosition == searchString.length
        } else false
    }
}