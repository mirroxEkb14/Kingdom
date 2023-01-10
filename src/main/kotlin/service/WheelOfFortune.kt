package service

/**
 * Returns a random number that defines stats for the Ruler and Heirs
 */
class WheelOfFortune {
    companion object {
        private const val RULER_MAX_STAT_RATE = 100
        private const val HEIR_MAX_STAT_RATE = (RULER_MAX_STAT_RATE * 0.7).toInt() // max can be 70% of Ruler's rate

        fun rulerCoefficient(): Double {
            val double = (0 .. RULER_MAX_STAT_RATE).random() / RULER_MAX_STAT_RATE.toDouble()
            return getRoundedDouble(double)
        }

        fun heirCoefficient(): Double {
            val double = (0 until  HEIR_MAX_STAT_RATE).random() / HEIR_MAX_STAT_RATE.toDouble()
            return getRoundedDouble(double)
        }

        // rounds a floating-point number to the form 0.00
        fun getRoundedDouble(number: Double) = String.format("%.2f", number).toDouble()
    }
}