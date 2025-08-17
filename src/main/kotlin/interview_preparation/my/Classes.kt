package interview_preparation.my
// const val test = 1 + 1
fun main() {
    val interviewExample = InterviewExample(isSecond = false, name = "slava")

    
}

class InterviewExample(var name: String) {

    init {
        println("init this with name: $name")
    }

    private fun delete() {
        //...
    }

    constructor(isSecond: Boolean, name: String) : this (name = if (isSecond) "234" else name) {
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}

//class Student(var name: String) {
//
//    init {
//        println("Student has got a name as $name")
//    }
//
//    constructor(sectionName: String, var id: Int)
//}

//А роза упала на лапу Азора