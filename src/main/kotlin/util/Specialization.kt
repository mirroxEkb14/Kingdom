package util

/**
 * Enum contains all available types of warriors
 * and their weapon type
 */
enum class Specialization(weapon: Weapon) {
    BOW_MAN(Weapon.BOW),
    CROSSBOW_MAN(Weapon.CROSSBOW),
    SWORD_MAN(Weapon.SWORD),
    AXE_MAN(Weapon.AXE)
}