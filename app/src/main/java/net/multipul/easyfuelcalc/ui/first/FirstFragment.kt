package net.multipul.easyfuelcalc.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_first.*
import net.multipul.easyfuelcalc.FuelCalcHelper
import net.multipul.easyfuelcalc.R
import kotlin.properties.Delegates

class FirstFragment : Fragment() {

    private lateinit var homeViewModel: FirstViewModel
    private lateinit var fuelCalcHelper: FuelCalcHelper

    private var fuel by Delegates.notNull<Int>()
    private var distance by Delegates.notNull<Int>()

//    lateinit var fuel: Int
//    lateinit var distance: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_first, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        if (valueDistanceType != null && valueDistanceType != null) {
//            valueFuelType.text
//            valueDistanceType.text
//        }

//        button.setOnClickListener {
//            fuelCalcHelper.averageFuel(fuel, distance)
//            resTV.setText(fuelCalcHelper.resFuel)
//        }
        return root
    }
}