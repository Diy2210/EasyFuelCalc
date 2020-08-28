package net.multipul.easyfuelcalc.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_second.*
import net.multipul.easyfuelcalc.helper.FuelCalcHelper
import net.multipul.easyfuelcalc.R
import net.multipul.easyfuelcalc.model.SecondModel

class SecondFragment : Fragment() {

    private lateinit var secondViewModel: SecondViewModel
    private var fuelCalcHelper: FuelCalcHelper = FuelCalcHelper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        secondViewModel =
            ViewModelProviders.of(this).get(SecondViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_second, container, false)

        root.button.setOnClickListener {
            val distance = valueDist.text.toString()
            val average = valueAverage.text.toString()
            val cost = valueCost.text.toString()

            val v = SecondModel(distance.toFloat(), average.toFloat(), cost.toFloat())

            if (distance.isEmpty() || average.isEmpty() || cost.isEmpty()) {
                Toast.makeText(requireContext(), "Empty fields!", Toast.LENGTH_LONG).show()
            } else {
                fuelCalcHelper.costTravel(v.distance, v.average, v.cost)
                resFuelTV.text = (getString(R.string.result_cost_travel_fuel_desc) + " " + fuelCalcHelper.result + " литров")
                resCostTV.text = (getString(R.string.result_cost_travel_cost_desc) + " " + fuelCalcHelper.res + " .грн")
            }
        }
        return root
    }
}