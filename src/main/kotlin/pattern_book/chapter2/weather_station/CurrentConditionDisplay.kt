package pattern_book.chapter2.weather_station

class CurrentConditionDisplay : Observer, Display {

    private var temp: Float = 0f
    private var humidity: Float = 0f
    private var pressure: Float = 0f

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temp = temp
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("temp: $temp, humidity: $humidity, pressure: $pressure")
    }
}