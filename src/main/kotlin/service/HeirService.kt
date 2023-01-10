package service

import model.Heir

/**
 * Contains the list with heirs and related methods
 */
class HeirService {
    private val heirs = mutableListOf<Heir>()

    fun addHeirs(amount: Int) {
        for (i in 1..amount) {
            heirs.add(Heir("Heir$i"))
        }
    }

    fun showHeirs() {
        heirs.forEach { heir ->
            println("Name: ${heir.name}\nIntellect: ${heir.intellect}\nPower: ${heir.power}")
        }
    }

    /**
     * Check if there is at least one heir in the list,
     * if so return the list and if not return null
     *
     * @return      either the list or null
     */
    fun getHeirs(): MutableList<Heir>? = if (heirs.isEmpty()) null else heirs
}
