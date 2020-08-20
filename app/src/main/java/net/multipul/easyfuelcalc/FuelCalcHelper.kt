package net.multipul.easyfuelcalc

import kotlin.properties.Delegates

class FuelCalcHelper {

    var resFuel by Delegates.notNull<Float>()
    var resCostTravel by Delegates.notNull<Float>()
    var resDistance by Delegates.notNull<Float>()
    var resCostDistance by Delegates.notNull<Float>()

    lateinit var result: String

    fun averageFuel(fuel: Float, distance: Float) {
        resFuel = (fuel * 100 / distance)
        result = "%.2f".format(resFuel)
    }

    fun costTravel(fuel: Float, distance: Float, average: Float) {
        resCostTravel = average * 100 / distance
    }

    fun howMachFuel(average: Float, fuel: Float) {
        resDistance = fuel / average * 100
    }

    fun costDistance(average: Float, cost: Float) {
        resCostDistance = average * cost / 100
    }
}