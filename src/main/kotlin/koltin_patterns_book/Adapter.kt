package koltin_patterns_book

fun main() {
    cellPhone(
        charger(
            usPowerOutlet().toEUPlug()
        ).toUsbTypeC()
    )
}

private interface USPlug {
    val hasPower: Int
}

private interface EUPlug {
    val hasPower: String
}

private interface UsbMini {
    val hasPower: PowerState
}

private enum class PowerState {
    TRUE, FALSE
}

private interface UsbTypeC {
    val hasPower: Boolean
}

private fun cellPhone(chargeSable: UsbTypeC) {
    if (chargeSable.hasPower) {
        println("power is ON")
    } else {
        println("No power")
    }
}

private fun usPowerOutlet(): USPlug {
    return object : USPlug {
        override val hasPower = 1
    }
}

private fun charger(plug: EUPlug): UsbMini {
    return object : UsbMini {
        override val hasPower: PowerState
            get() = if (plug.hasPower == "YES") PowerState.TRUE else PowerState.FALSE
    }
}

private fun USPlug.toEUPlug() = object : EUPlug {
    override val hasPower: String
        get() = if (this@toEUPlug.hasPower == 1) "YES" else "NO"
}

private fun UsbMini.toUsbTypeC() = object : UsbTypeC {
    override val hasPower: Boolean
        get() = this@toUsbTypeC.hasPower == PowerState.TRUE
}