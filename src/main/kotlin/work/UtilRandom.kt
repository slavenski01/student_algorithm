package work

import kotlin.random.Random

fun main() {
    val randomParam = RandomParam()
    randomParam.addParam("Woman", 63)
    randomParam.addParam("Man", 36)
    randomParam.addParam("Other", 1)

    var manCnt = 0
    var womanCnt = 0
    var otherCnt = 0

    for (i in 0..100000) {
        when (randomParam.getRandomParam()) {
            "Woman" -> {
                womanCnt++
            }
            "Man" -> {
                manCnt++
            }
            else -> {
                otherCnt++
            }
        }
    }

    println("woman: $womanCnt, man: $manCnt, other: $otherCnt")
}

class RandomParam : RandomParamSet, RandomGenerateParam {

    private var currentBorderChance = 0
    private val paramsMap = mutableMapOf<Any, IntRange>()

    override fun addParam(name: Any, chance: Int) {
        if (isCurrentChance(
                crntBorderChance = currentBorderChance,
                targetChance = chance
            )
        ) {
            paramsMap[name] = (currentBorderChance + 1)..(chance + currentBorderChance)
            currentBorderChance += chance
        } else {
            return
        }
    }

    override fun getRandomParam(): Any? {
        if (paramsMap.size == 1) {
            return paramsMap.keys.first()
        }
        if (isCompleteChance()) {
            val rndmProbability = Random.nextInt(0, MAX_CHANCE)
            for ((key, value) in paramsMap) {
                if (rndmProbability in value) return key
            }
        }
        return null
    }

    override fun dropParam(name: Any) {
        paramsMap.remove(name)
    }

    private fun isCurrentChance(crntBorderChance: Int, targetChance: Int): Boolean {
        return crntBorderChance + targetChance <= MAX_CHANCE
    }

    private fun isCompleteChance(): Boolean = currentBorderChance == MAX_CHANCE

    companion object {
        private const val MAX_CHANCE = 100
    }
}

interface RandomParamSet {
    fun addParam(name: Any, chance: Int)
    fun dropParam(name: Any)
}

interface RandomGenerateParam {
    fun getRandomParam(): Any?
}