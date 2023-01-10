package model

import service.WheelOfFortune
import util.Printable

/**
 * This is a king of the kingdom. The king has heirs, so the class
 * is 'open'. Contains the main variables: name, intellect, power
 * (all the heirs will have them, too)
 */
open class Ruler(name: String) : Noble(name), Printable {

    // the ruler has higher stats(at least twice as much)
    init {
        intellect += WheelOfFortune.rulerCoefficient()
        power += WheelOfFortune.rulerCoefficient()
    }

    override fun print() {
        println("Name: $name\nIntellect: $intellect\nPower: $power")
    }

    companion object {
        fun geroldGreetings() {
            println("The King is in the building.")
        }
    }
}