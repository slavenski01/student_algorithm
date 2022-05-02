package pattern_book.chapter2.weather_station

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}