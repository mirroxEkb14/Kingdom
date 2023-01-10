package service

import model.Peasant
import util.Occupation

class TaxService {
    private var treasury = 0

    private var workerTaxes = 0
    private var builderTaxes = 0
    private var farmerTaxes = 0

    /**
     * If the 'occupation' field is not passed, then we collect from all the peasants
     *
     * @param peasants      [ [], [], [] ]
     * @param occupation    Occupation.WORKER or Occupation.BUILDER or Occupation.FARMER or null
     * @return
     */
    fun collect(peasants: List<List<Peasant>>, occupation: Occupation? = null) {
        peasants.forEach { peasantGroup ->

            // calculate the tax for the whole group
            val taxRate = peasantGroup[0].occupation.taxRate
            val peasantGroupSize = peasantGroup.size
            val taxAmount = taxRate * peasantGroupSize
            treasury += taxAmount

            // define the group and add the tax amount to a related variable
            // to keep track of how much money paid each group of peasants
            when (peasantGroup[0].occupation) {
                Occupation.WORKER -> workerTaxes += taxAmount
                Occupation.BUILDER -> builderTaxes += taxAmount
                Occupation.FARMER -> farmerTaxes += taxAmount
            }
        }
    }

    fun showTreasury() {
        println("King`s treasury: $treasury gold")
    }

    fun showCertain(occupation: Occupation) {
        when (occupation) {
            Occupation.WORKER -> println("Workers: $workerTaxes")
            Occupation.BUILDER -> println("Builders: $builderTaxes")
            Occupation.FARMER -> println("Farmers: $farmerTaxes")
        }
    }
}