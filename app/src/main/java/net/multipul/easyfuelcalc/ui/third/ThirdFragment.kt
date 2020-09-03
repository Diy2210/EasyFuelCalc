package net.multipul.easyfuelcalc.ui.third

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_first.resTV
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.valueAverage
import net.multipul.easyfuelcalc.helper.FuelCalcHelper
import net.multipul.easyfuelcalc.R
import net.multipul.easyfuelcalc.model.ThirdModel

class ThirdFragment : Fragment() {

    private lateinit var notificationsViewModel: ThirdViewModel
    private var fuelCalcHelper: FuelCalcHelper = FuelCalcHelper()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(ThirdViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_third, container, false)

        root.button.setOnClickListener {
            val fuel = valueFuel.text.toString()
            val average = valueAverage.text.toString()

            val v = ThirdModel(average.toFloat(), fuel.toFloat())

            if (fuel.isEmpty() || average.isEmpty()) {
                Toast.makeText(requireContext(), "Empty fields!", Toast.LENGTH_LONG).show()
            } else {
                fuelCalcHelper.fuelToDistance(v.fuel, v.average)
//                resTV.text = (getString(R.string.result_fuel_to_dist_desc) + " " + fuelCalcHelper.result + " км.")

                fuelCalcHelper.r.observe(viewLifecycleOwner,
                    { t -> resTV.text = getString(R.string.result_fuel_to_dist_desc) + " " + t!!.toString() + " км." })

            }
        }
        return root
    }
}