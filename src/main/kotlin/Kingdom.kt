import model.Heir
import model.Ruler
import service.ArmyService
import service.HeirService
import service.PeasantService
import service.TaxService
import util.Occupation
import util.Specialization

val kingdom = Kingdom()

fun main(args: Array<String>) {
    println()
    Ruler.geroldGreetings()

    println()
    "we are under attack!".yourHighness()

    println()
    println("The King himself -> ")
    kingdom.ruler.print()

    println()

    println("-----------------")
    println("The King heirs -> ")
    kingdom.heirService.showHeirs()
    println()
    println("The heir of the Throne is -> ")
    when (val heir = kingdom.getThroneHeir()) {
        null -> println("No heir yet.")
        else -> heir.print()
    }
    println("-----------------")

    println()

    println("-----------------")
    println("The garrisons: ")
    kingdom.armyService.showGarrisons()
    println()
    println("The army: ")
    kingdom.armyService.showForces()
    println()
    println("The Great Army: ")
    kingdom.armyService.upgradeArmy()
    kingdom.armyService.showForces()
    println("-----------------")

    println()

    println("-----------------")
    println("Folks: ")
    kingdom.peasantService.showPeasants()
    println()
    println("Folks by types: ")
    kingdom.peasantService.showByTypes()
//    println()
//    println("Folks are getting acquainted: ")
//    kingdom.peasantService.giveFunToPeasants()
    println("-----------------")

    println()
    println("-----------------")
    println("Taxes from all peasants: ")
    kingdom.taxService.showTreasury()
    println()
    println("Taxes from certain peasants: ")
    kingdom.taxService.showCertain(Occupation.WORKER)
    kingdom.taxService.showCertain(Occupation.BUILDER)
    kingdom.taxService.showCertain(Occupation.FARMER)

    println("-----------------")
}

class Kingdom {
    val heirService = HeirService()
    val armyService = ArmyService()
    val peasantService = PeasantService()

    val taxService = TaxService()

    val ruler = Ruler("Arthur")

    init {
        heirService.addHeirs(2)
        armyService.apply {
            increaseArmy(
                formGarrison(Specialization.BOW_MAN, 50),
                formGarrison(Specialization.CROSSBOW_MAN, 30),
                formGarrison(Specialization.SWORD_MAN, 100),
                formGarrison(Specialization.AXE_MAN, 70)
            )
        }
        peasantService.addPeasants(100)
        taxService.collect(peasantService.getPeasants())
    }

    /**
     * Compare heirs' stats
     *
     * @return      the one with higher stats or null
     */
    fun getThroneHeir(): Heir? = heirService.getHeirs()?.maxByOrNull { it.power + it.intellect }
}

// extension
fun String.yourHighness() = println("Your Highness, $this")
