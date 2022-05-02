package pattern_book.chapter6.pattern_command

class GarageDoor {
    fun up() {
        print("garage door is open")
    }
    fun down() {
        print("garage door is close")
    }
    fun stop() {
        print("garage opening door is stopped")
    }
    fun lightOn() {
        print("garage light is On")
    }
    fun lightOff() {
        print("garage light is Off")
    }
}