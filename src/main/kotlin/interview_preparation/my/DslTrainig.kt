package interview_preparation.my

fun main() {
    val blockBanner: BannerConstructor = bannerConstructor {
        background {
            onMove = "#123145"
            moving = "#123167"
            click = "#123198"
        }
        roundCorners {
            left = 16
            right = 12
        }
        config {
            ripple = true
            moving = false
            clickable = true
        }
    }
    println(blockBanner)
}

private class BannerConstructor private constructor(
    val background: Background,
    val roundCorners: RoundCorners,
    val config: Config
) {
    class Builder {
        private lateinit var background: Background
        private lateinit var config: Config
        private lateinit var roundCorners: RoundCorners

        fun background(initBlock: Background.() -> Unit): Builder {
            background = Background().apply { initBlock() }
            return this
        }

        fun config(initBlock: Config.() -> Unit): Builder {
            config = Config().apply(initBlock)
            return this
        }

        fun roundCorners(initBlock: RoundCorners.() -> Unit): Builder {
            roundCorners = RoundCorners().apply(initBlock)
            return this
        }

        fun build(): BannerConstructor = BannerConstructor(background, roundCorners, config)
    }

    override fun toString(): String {
        return "background: $background, roundCorners: $roundCorners, config: $config"
    }
}

private class Background {
    var onMove = ""
    var moving = ""
    var click = ""

    override fun toString(): String {
        return "onMove: $onMove, moving: $moving, click: $click"
    }
}

private class RoundCorners {
    var left = 0
    var right = 0

    override fun toString(): String {
        return "left: $left, right: $right"
    }
}

private class Config {
    var ripple = false
    var moving = false
    var clickable = false

    override fun toString(): String {
        return "ripple: $ripple, moving: $moving, clickable: $clickable"
    }
}

private fun bannerConstructor(initBlock: BannerConstructor.Builder.() -> Unit): BannerConstructor {
    return BannerConstructor.Builder().apply(initBlock).build()
}