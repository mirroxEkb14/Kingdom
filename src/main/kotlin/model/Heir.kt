package model

import service.WheelOfFortune
import util.Printable

/**
 * This is an heir of the king('Ruler' class). Contains same fields but
 * the values of 'intellect' and 'power' fields are set randomly
 */
class Heir(name: String) : Noble(name), Printable {
    init {
        intellect = WheelOfFortune.getRoundedDouble(WheelOfFortune.heirCoefficient() * intellect)
        power = WheelOfFortune.getRoundedDouble(WheelOfFortune.heirCoefficient() * power)
    }

    override fun print() { println("Name: $name\nIntellect: $intellect\nPower: $power") }
}