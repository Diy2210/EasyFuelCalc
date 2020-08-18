package net.multipul.easyfuelcalc

import kotlin.properties.Delegates

class FuelCalcHelper {

    var resFuel by Delegates.notNull<Int>()
    var resCostTravel by Delegates.notNull<Int>()
    var resDistance by Delegates.notNull<Int>()
    var resCostDistance by Delegates.notNull<Int>()

    fun averageFuel(fuel: Int, distance: Int) {
        resFuel = fuel * 100 / distance
    }

    fun costTravel(fuel: Int, distance: Int, average: Int) {
        resCostTravel = average * 100 / distance
    }

    fun howMachFuel(average: Int, fuel: Int) {
        resDistance = fuel / average * 100
    }

    fun costDistance(average: Int, cost: Int) {
        resCostDistance = average * cost / 100
    }
}