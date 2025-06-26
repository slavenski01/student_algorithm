package koltin_patterns_book

fun main() {

}

private interface Developer {
    fun writeCode(code: String)
    fun pushOnVcs()
}

private open class JuniorDeveloper: Developer {
    override fun writeCode(code: String) {
        println("I'm Junior")
    }

    override fun pushOnVcs() {
        println("git.push on Junior Repo")
    }
}

private open class SeniorDeveloper: Developer {
    override fun writeCode(code: String) {
        println("I'm Senior and my code: $code")
    }

    override fun pushOnVcs() {
        println("git.push on Senior Repo")
    }
}

private class TechLead: SeniorDeveloper() {
    override fun writeCode(code: String) {
        super.writeCode(code)
        println("plus i have achievement TechLead!")
    }
}