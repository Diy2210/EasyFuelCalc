package net.multipul.easyfuelcalc.ui.fourth

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
import kotlinx.android.synthetic.main.fragment_fourth.*
import net.multipul.easyfuelcalc.helper.FuelCalcHelper
import net.multipul.easyfuelcalc.R
import net.multipul.easyfuelcalc.model.FourthModel

class FourthFragment : Fragment() {

    private lateinit var fourthViewModel: FourthViewModel
    private var fuelCalcHelper: FuelCalcHelper = FuelCalcHelper()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fourthViewModel = ViewModelProviders.of(this).get(FourthViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_fourth, container, false)

        root.button.setOnClickListener {
            val average = valueAverage.text.toString()
            val cost = valueCost.text.toString()

            val v = FourthModel(average.toFloat(), cost.toFloat())

            if (average.isEmpty() || cost.isEmpty()) {
                Toast.makeText(requireContext(), "Empty fields!", Toast.LENGTH_LONG).show()
            } else {
                fuelCalcHelper.costDistance(v.average, v.cost)
//                resTV.text = (getString(R.string.result_cost_to_dist_desc) + " " + fuelCalcHelper.result + " " + getString(R.string.money_value_uah))

                fuelCalcHelper.r.observe(viewLifecycleOwner,
                    { t -> resTV.text = getString(R.string.result_cost_to_dist_desc) + " " + t!!.toString() + getString(R.string.money_value_uah) })

            }
        }

        return root
    }
}