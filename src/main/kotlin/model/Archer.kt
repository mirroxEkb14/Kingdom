package model

/**
 * Every archer has a bow, but some also have a dagger
 */

data class Archer(var bow: String, val dagger: String) {
    constructor(dagger: String) : this("LongBow", dagger)
}