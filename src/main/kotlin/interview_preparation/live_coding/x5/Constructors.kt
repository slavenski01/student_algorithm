package interview_preparation.live_coding.x5

fun main() {
    val student = Student("fdf")
}

private class Student(var name: String) {
    init {
        println("Student has got a name as $name")
    }

    constructor(sectionName: String, id: Int) : this(sectionName) {
    }
}

//Требуется:
//
//Объяснить, как работают первичный и вторичный конструкторы.
//Указать, как вызываются эти конструкторы, и в каком порядке выполняются блоки init.
//Указать, какие данные передаются в свойства класса при создании объектов.

// Ответы
// Во-первых нельза во вторичном конструкторе использовать val/var,
// потому что под капотом это просто функция для создания объекта