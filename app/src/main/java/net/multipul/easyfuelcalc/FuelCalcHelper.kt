package net.multipul.easyfuelcalc

import kotlin.properties.Delegates

class FuelCalcHelper {

    var resFuel by Delegates.notNull<Float>()
    var resCostTravel by Delegates.notNull<Float>()
    var needFuel by Delegates.notNull<Float>()
    var resDistance by Delegates.notNull<Float>()
    var resCostDistance by Delegates.notNull<Float>()

    lateinit var result: String
    lateinit var res: String

    fun averageFuel(fuel: Float, distance: Float) {
        resFuel = (fuel * 100 / distance)
        result = "%.2f".format(resFuel)
    }

    fun costTravel(distance: Float, average: Float, cost: Float) {
        needFuel = distance / 100 * average
        result = "%.2f".format(needFuel)

        resCostTravel = cost * needFuel
        res = "%.2f".format(resCostTravel)
    }

    fun fuelToDistance(fuel: Float, average: Float) {
        resDistance = fuel / average * 100
        result = "%.2f".format(resDistance)
    }

    fun costDistance(average: Float, cost: Float) {
        resCostDistance = average * cost / 100
        result = "%.2f".format(resCostDistance)
    }
}