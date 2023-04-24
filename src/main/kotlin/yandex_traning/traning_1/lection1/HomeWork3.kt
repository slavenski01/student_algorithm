package yandex_traning.traning_1.lection1

//валидация добавления телефонного номера
/***
 * форматы номеров:
 *  +7<код><номер>
 *  8<код><номер>
 *  <номер>
 *  если код не указан, то он равен 495
 *  может стоять тире между любыми цифрами
 *  телефон1 == телефонн2 если код + номер совпали
 * */
fun main() {
    val requestNum = readLine() ?: return
    val num1 = readLine() ?: return
    val num2 = readLine() ?: return
    val num3 = readLine() ?: return

    println(validateNumber(num1, requestNum))
    println(validateNumber(num2, requestNum))
    println(validateNumber(num3, requestNum))
}

fun validateNumber(numReq: String, numTest: String): String {
    var cleanNumReq = numReq
        .replace("-", "")
        .replace("+7", "")
        .replace("(", "")
        .replace(")", "")

    var cleanNumTest = numTest
        .replace("-", "")
        .replace("+7", "")
        .replace("(", "")
        .replace(")", "")

    if (cleanNumReq.length == 7) {
        cleanNumReq = "495$cleanNumReq"
    }

    if (cleanNumReq.length == 11) {
        cleanNumReq = cleanNumReq.substring(1)
    }

    if (cleanNumTest.length == 7) {
        cleanNumTest = "495$cleanNumTest"
    }

    if (cleanNumTest.length == 11) {
        cleanNumTest = cleanNumTest.substring(1)
    }

    return if (cleanNumReq == cleanNumTest) "YES" else "NO"
}