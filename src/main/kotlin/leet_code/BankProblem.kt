package leet_code

fun main() {
    val startCapital = 315170.6f
    val percentBank = 21.0f
    val targetSum = 2189361.79f
    val importantCost = 25767

    val box = piggyBankProblem(
        startCapital = startCapital,
        targetSum = targetSum,
        percentBank = percentBank,
        importantCost = importantCost
    ) ?: return

    println("box for moneybox: $box")
    println("summ on box: ${sumOfBox(box, startCapital, percentBank)}")
}


private fun piggyBankProblem(
    startCapital: Float,
    targetSum: Float,
    percentBank: Float,
    importantCost: Int
): MoneyBox? {
    val vkladMoneyBox = MoneyBox(
        type = TypeMoneyBox.VKLAD,
        months = calcMonthsForBankResolveVklad(
            startCapital = startCapital,
            targetSum = targetSum,
            percentBank = percentBank,
            importantCost = importantCost
        )
    )

    val kopilkaMoneyBox = MoneyBox(
        type = TypeMoneyBox.KOPILKA,
        months = calcWithourVklad(
            startCapital = startCapital,
            targetSum = targetSum,
            importantCost = importantCost
        )
    )

    return listOf(vkladMoneyBox, kopilkaMoneyBox).minByOrNull { it.months }
}

private fun calcWithourVklad(
    startCapital: Float,
    targetSum: Float,
    importantCost: Int
): Int {
    var currentMoney = startCapital
    var iterations = 0
    while (currentMoney < targetSum) {
        currentMoney += 100000 + importantCost
        iterations++
    }
    return iterations
}

private fun calcMonthsForBankResolveVklad(
    startCapital: Float,
    targetSum: Float,
    percentBank: Float,
    importantCost: Int
): Int {
    var currentMoney = startCapital
    var iterations = 0
    while (currentMoney < targetSum) {
        var currentPercent = ((currentMoney / 100) * percentBank) / 12
        currentMoney += (currentPercent + 100000 + importantCost)
        iterations++
    }
    return iterations
}

private fun sumOfBox(
    box: MoneyBox,
    startCapital: Float,
    percentBank: Float
): Float {
    var summ = startCapital
    for (i in 0..box.months) {
        val currentPercentSum = (((summ / 100) * percentBank) / 12)
        summ += (currentPercentSum + 100000)
    }
    return summ
}

data class MoneyBox(
    val type: TypeMoneyBox,
    val months: Int
)

enum class TypeMoneyBox {
    VKLAD, KOPILKA
}