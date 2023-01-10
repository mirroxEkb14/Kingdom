package model

import util.Occupation
import util.Printable

data class Peasant(val occupation: Occupation) : Printable {
    override fun print() {
        println("Occupation: $occupation")
    }
}