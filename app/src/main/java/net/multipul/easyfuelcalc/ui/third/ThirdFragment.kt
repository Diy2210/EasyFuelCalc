package net.multipul.easyfuelcalc.ui.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_first.resTV
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_third.*
import net.multipul.easyfuelcalc.helper.FuelCalcHelper
import net.multipul.easyfuelcalc.R
import net.multipul.easyfuelcalc.model.ThirdModel

class ThirdFragment : Fragment() {

    private lateinit var notificationsViewModel: ThirdViewModel
    private var fuelCalcHelper: FuelCalcHelper = FuelCalcHelper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(ThirdViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_third, container, false)

        root.button.setOnClickListener {
            val average = valueAverage.text.toString()
            val fuel = valueFuel.text.toString()

            val v = ThirdModel(average.toFloat(), fuel.toFloat())

            if (average.isEmpty() || fuel.isEmpty()) {
                Toast.makeText(requireContext(), "Empty fields!", Toast.LENGTH_LONG).show()
            } else {
                fuelCalcHelper.fuelToDistance(v.average, v.fuel)
                resTV.text = (getString(R.string.result_fuel_to_dist_desc) + " " + fuelCalcHelper.result + " км.")
            }
        }
        return root
    }
}