package service

import model.Fighter
import util.Specialization
import util.Weapon

/**
 * Contains the list with army and related methods
 */
private const val ARCHER_TYPE = "Archer"
private const val MELEE_WEAPON = "Melee"

class ArmyService {
    private val army = formArmy()

    /**
     * @param garrison      map with a key of Specialization and value of amount
     *                      units with this Specialization
     * @return              [ [SWORDMEN], [AXEMEN], [CROSSBOWMEN], [BOWMEN] ]
     */
    private fun addSoldiers(garrison: Map<Specialization, Int>) {
        garrison.forEach { specializedGarrison ->
            val soldiersType = specializedGarrison.key
            val soldiersAmount = specializedGarrison.value

            when (soldiersType) {
                Specialization.SWORD_MAN -> {
                    repeat(soldiersAmount) {
                        army[0].add(Fighter(Specialization.SWORD_MAN))
                    }
                }
                Specialization.AXE_MAN -> {
                    repeat(soldiersAmount) {
                        army[1].add(Fighter(Specialization.AXE_MAN))
                    }
                }
                Specialization.CROSSBOW_MAN -> {
                    repeat(soldiersAmount) {
                        army[2].add(Fighter(Specialization.CROSSBOW_MAN))
                    }
                }
                Specialization.BOW_MAN -> {
                    repeat(soldiersAmount) {
                        army[3].add(Fighter(Specialization.BOW_MAN))
                    }
                }
            }
        }
    }

    /**
     * @param specialization    Specialization for which we upgrade the weapon,
     *                          if null then upgrade the weapon for all the garrisons
     */
    fun upgradeArmy(specialization: Specialization? = null) {
        when (specialization) {
            null -> {
                army.forEach { garrison ->
                    garrison.forEach { fighter ->
                        when (fighter.specialization) {
                            Specialization.BOW_MAN -> { fighter.upgradeWeapon(Weapon.COMPOSITE_BOW) }
                            Specialization.CROSSBOW_MAN -> { fighter.upgradeWeapon(Weapon.COMPOSITE_CROSSBOW) }
                            Specialization.SWORD_MAN -> { fighter.upgradeWeapon(Weapon.COMPOSITE_SWORD) }
                            Specialization.AXE_MAN -> { fighter.upgradeWeapon(Weapon.COMPOSITE_AXE) }
                        }
                    }
                }
            }
            Specialization.SWORD_MAN -> army[0].forEach { fighter -> fighter.upgradeWeapon(Weapon.COMPOSITE_SWORD) }
            Specialization.AXE_MAN -> army[1].forEach { fighter -> fighter.upgradeWeapon(Weapon.COMPOSITE_AXE) }
            Specialization.CROSSBOW_MAN -> army[2].forEach { fighter -> fighter.upgradeWeapon(Weapon.CROSSBOW) }
            Specialization.BOW_MAN -> army[3].forEach { fighter -> fighter.upgradeWeapon(Weapon.BOW) }
        }
    }

    fun increaseArmy(vararg garrisons: Pair<Specialization, Int>) {
        garrisons.forEach { garrison ->
            addSoldiers(mapOf(garrison))
        }
    }

    /**
     * @return      Pair<Specialization, Int>
     *              key-value pair with Specialization type and amount of soldiers
     */
    fun formGarrison(garrisonType: Specialization, soldiersAmount: Int) = Pair(garrisonType, soldiersAmount)

    fun showGarrisons() {
        army.forEach { garrison ->
            println("Soldiers type: ${getFighterType(garrison[0].specialization)}\nForces: ${garrison.size}\n${garrison}")
        }
    }

    fun showForces() {
        army.forEach { garrison ->
            garrison.forEach { fighter ->
                println(fighter)
            }
        }
    }

    /**
     * @return      either Melee or Archer types according to their Specialization
     */
    private fun getFighterType(specialization: Specialization): String =
        when (specialization) {
            Specialization.SWORD_MAN -> MELEE_WEAPON
            Specialization.AXE_MAN -> MELEE_WEAPON
            Specialization.BOW_MAN -> ARCHER_TYPE
            Specialization.CROSSBOW_MAN -> ARCHER_TYPE
    }

    /**
     * @return      [ [], [], [], [] ]
     */
    private fun formArmy(): List<MutableList<Fighter>> {
        val template = ArrayList<MutableList<Fighter>>(Specialization.values().size)
        val soldersTypesAmount = Specialization.values().size

        repeat(soldersTypesAmount) { template.add(mutableListOf()) }
        return template
    }
}