package net.multipul.easyfuelcalc.ui.fourth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import net.multipul.easyfuelcalc.FuelCalcHelper
import net.multipul.easyfuelcalc.R

class FourthFragment : Fragment() {

    private lateinit var fourthViewModel: FourthViewModel
    private var fuelCalcHelper: FuelCalcHelper = FuelCalcHelper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fourthViewModel = ViewModelProviders.of(this).get(FourthViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_fourth, container, false)

        return root
    }
}