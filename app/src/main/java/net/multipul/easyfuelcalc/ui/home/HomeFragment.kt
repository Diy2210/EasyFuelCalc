package net.multipul.easyfuelcalc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.*
import net.multipul.easyfuelcalc.FuelCalcHelper
import net.multipul.easyfuelcalc.R
import kotlin.properties.Delegates

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fuelCalcHelper: FuelCalcHelper

    private var fuel by Delegates.notNull<Int>()
    private var distance by Delegates.notNull<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        fuel = valueFuelType.text
        distance = valueDistanceType.text

        button.setOnClickListener{
            fuelCalcHelper.averageFuel(fuel, distance)
            resTV.setText(fuelCalcHelper.resFuel)
        }
        return root
    }
}