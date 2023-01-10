package model

/**
 * Thw whole high society is nobles, so this is abstract and
 * all the monarchy will be inherited from this class
 *
 * The class has fields that every monarch has: intellect and power
 */
abstract class Noble(val name: String) {
    var intellect: Double = DEFAULT_NOBLE_INTELLECT
    var power: Double = DEFAULT_NOBLE_POWER

    companion object {
        const val DEFAULT_NOBLE_INTELLECT = 10.0
        const val DEFAULT_NOBLE_POWER = 10.0
    }
}