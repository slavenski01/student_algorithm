package koltin_patterns_book

fun main() {
    val abstractFabric = AbstractFabric()
}

private class AbstractFabric {
    interface Property {
        val name: String
        val value: Any
    }

    interface ServerConfiguration {
        val properties: List<Property>
    }

    data class PropertyImpl(
        override val name: String,
        override val value: Any,
    ): Property

    data class ServerConfigurationImpl(
        override val properties: List<Property>
    ): ServerConfiguration

    fun property(prop: String): Property {
        val (name, value) = prop.split(":")
        return when(name) {
            "port" -> PropertyImpl(name = name, value = value.trim().toInt())
            "environment" -> PropertyImpl(name, value = value.trim())
            else -> throw IllegalArgumentException("Unknown property: $name")
        }
    }

    fun testTypesProperties() {

    }
}