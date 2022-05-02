package pattern_book.chapter2.weather_station

fun main() {
    WeatherData().apply {
        val display = CurrentConditionDisplay()
        registerObserver(display)
        setMeasurements(temp = 113f, humidity = 22f, pressure = 9f)
        setMeasurements(temp = 40f, humidity = 50f, pressure = 9f)
        setMeasurements(temp = 9f, humidity = 222f, pressure = 55f)
        removeObserver(display)
        setMeasurements(temp = 1f, humidity = 1f, pressure = 1f)
    }
}