package service

import model.Peasant
import util.Occupation

class PeasantService {
    private val peasants = formPeasants()

    /**
     * Each peasant from each group meets all the peasants from the list
     * and if their occupation is the same, they greet, otherwise they're surprised
     */
    fun giveFunToPeasants() {
        peasants.forEach { peasantGroup1 ->
            peasantGroup1.forEach { peasant1 ->
                peasants.forEach { peasantGroup2 ->
                    peasantGroup2.forEach { peasant2 ->
                        if (peasant1.occupation == peasant2.occupation) println("Hey colleague!")
                        else println("See you for the first time...")
                    }
                }
            }
        }
    }

    fun addPeasants(amount: Int) {
        repeat(amount) { times ->
            when {
                times % 3 == 0 -> peasants[0].add(Peasant(Occupation.FARMER))
                times % 2 == 0 -> peasants[1].add(Peasant(Occupation.BUILDER))
                else -> peasants[2].add(Peasant(Occupation.WORKER))
            }
        }
    }

    fun showPeasants() {
        println("${peasants.joinToString("\n")}\nAmount: ${peasants[0].size + peasants[1].size + peasants[2].size}")
    }

    fun showByTypes() {
        peasants.forEach { peasantsOfCertainType ->
            println("Occupation: ${peasantsOfCertainType[0].occupation}\tAmount: ${peasantsOfCertainType.size}")
        }
    }

    fun getPeasants(): List<MutableList<Peasant>> = peasants

    /**
     * @return      [ [], [], [] ]
     */
    private fun formPeasants(): List<MutableList<Peasant>> {
        val template = mutableListOf<MutableList<Peasant>>()
        val soldersTypesAmount = Occupation.values().size

        repeat(soldersTypesAmount) { template.add(mutableListOf()) }
        return template
    }
}