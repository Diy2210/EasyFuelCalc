package net.multipul.easyfuelcalc.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*
import net.multipul.easyfuelcalc.FuelCalcHelper
import net.multipul.easyfuelcalc.R
import net.multipul.easyfuelcalc.model.BaseModel

class FirstFragment : Fragment() {

    private lateinit var homeViewModel: FirstViewModel
    private var fuelCalcHelper: FuelCalcHelper = FuelCalcHelper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_first, container, false)

        root.button.setOnClickListener {
            val fuel = valueFuelType.text.toString()
            val distance = valueDistanceType.text.toString()

            val v = BaseModel(fuel.toFloat(), distance.toFloat())

            if (fuel.isEmpty() || distance.isEmpty()) {
                Toast.makeText(requireContext(), "Empty fields!", Toast.LENGTH_LONG).show()
            } else {
                fuelCalcHelper.averageFuel(v.fuel, v.distance)
                resTV.text = (getString(R.string.result_desc) + " " + fuelCalcHelper.result + " литров на 100 км.")
            }
        }
        return root
    }
}