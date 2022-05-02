package pattern_book.chapter6.pattern_command

class SimpleRemoteControl {
    private var slot: Command? = null

    fun setCommand(command: Command) {
        slot = command
    }

    fun buttonWasPressed() {
        slot?.execute()
    }
}