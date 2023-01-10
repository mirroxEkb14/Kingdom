package model

import util.Printable
import util.Specialization
import util.Weapon
import java.lang.IllegalArgumentException

/**
 * The fighter in our army includes all the Specializations
 */
data class Fighter(val specialization: Specialization) : Printable {

    private val type: String
    private var weapon: String
    private var force: Int
    private var agility: Int

    // set a fighter according to his Specialization
    init {
        when (specialization) {
            Specialization.BOW_MAN -> {
                type = Specialization.BOW_MAN.name
                weapon = Weapon.BOW.name
                force = 5
                agility = 10
            }

            Specialization.CROSSBOW_MAN -> {
                type = Specialization.CROSSBOW_MAN.name
                weapon = Weapon.CROSSBOW.name
                force = 10
                agility = 5
            }

            Specialization.SWORD_MAN -> {
                type = Specialization.SWORD_MAN.name
                weapon = Weapon.SWORD.name
                force = 15
                agility = 20
            }

            Specialization.AXE_MAN -> {
                type = Specialization.AXE_MAN.name
                weapon = Weapon.AXE.name
                force = 20
                agility = 15
            }
        }
    }

    override fun print() {
        println("Type: $type\nWeapon: $weapon\nForce: $force\nAgility: $agility")
    }

    override fun toString(): String {
        return "Type: $type\tWeapon: $weapon\tForce: $force\tAgility: $agility"
    }

    fun upgradeWeapon(weapon: Weapon) {
        when (weapon) {
            Weapon.COMPOSITE_BOW -> this.weapon = Weapon.COMPOSITE_BOW.name
            Weapon.COMPOSITE_CROSSBOW -> this.weapon = Weapon.COMPOSITE_CROSSBOW.name
            Weapon.COMPOSITE_SWORD -> this.weapon = Weapon.COMPOSITE_SWORD.name
            Weapon.COMPOSITE_AXE -> this.weapon = Weapon.COMPOSITE_AXE.name
            else -> throw IllegalArgumentException("Wrong weapon: $weapon")
        }
    }
}
