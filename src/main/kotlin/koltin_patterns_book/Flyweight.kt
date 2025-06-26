package koltin_patterns_book

typealias Sprite = String

object SnailSprites {
    val sprites = List(8) {
        when(it) {
            0 -> "leftFacing"
            1 -> "rightFacing"
            in 2..4 -> "leftFacing"
            else -> "rightFacing"
        }
    }
}

private class TansanianSnail {
    private val directionFacing = Direction.LEFT
    private val sprites = SnailSprites.sprites
}

enum class Direction {
    LEFT, RIGHT
}

