package util

/**
 * Contains all available types of peasants
 *
 * 'taxRate' defines the multiplier of taking taxes
 */
enum class Occupation(val taxRate: Int) {
    WORKER(1),
    BUILDER(2),
    FARMER(3)
}