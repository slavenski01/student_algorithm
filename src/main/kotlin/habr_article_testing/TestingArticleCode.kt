package habr_article_testing

fun main() {
    val parse: (String) -> List<Int> = { it.split(":").map(String::toInt) }

    val (xMin, yMin) = parse("12:23")
    val (xMax, yMax) = parse("23:53")
    println("xMin: $xMin, yMin: $yMin, xMax: $xMax, yMax: $yMax")
}