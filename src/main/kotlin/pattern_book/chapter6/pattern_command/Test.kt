package pattern_book.chapter6.pattern_command

fun main() {
    val remoteControl = SimpleRemoteControl()
    val garageDoor = GarageDoor()
    val commandGarageDoor = GarageDoorOpenCommand(garageDoor)
    remoteControl.setCommand(commandGarageDoor)
    remoteControl.buttonWasPressed()
}