package net.multipul.easyfuelcalc.ui.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import net.multipul.easyfuelcalc.App
import net.multipul.easyfuelcalc.R
import net.multipul.easyfuelcalc.model.SettingsModel
import kotlin.properties.Delegates

class SettingsFragment : Fragment() {

//    private lateinit var binding: FragmentSettingsBinding

    private lateinit var settingsViewModel: SettingsViewModel
    private var theme by Delegates.notNull<String>()
    var t: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)

        root.toggleButton.isEnabled
        root.toggleButton.textOn = "DAY"
        root.toggleButton.textOff = "NIGHT"
        root.toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

        root.radioTheme.setOnCheckedChangeListener { _, i ->
            if (i == R.id.radio_day) {
//                theme = false
                theme = "radio_day"
                t = false
                SettingsModel(theme)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                println("radio_day")
            } else if (i == R.id.radio_night) {
//                theme = true
                theme = "radio_night"
                t = true
                SettingsModel(theme)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                println("radio_night")
            }
        }

//        if (!t) {
//            radio_day.isChecked =
////            radio_night.isChecked(false)
//            println("radio_day.isChecked")
//        } else {
////            radio_day.isChecked(false)
//            radio_night.isChecked(true)
//            println("radio_night.isChecked")
//        }

//        binding.lifecycleOwner = viewLifecycleOwner

        return root
    }

//    fun onRadioButtonClicked(view: View) {
//        if (view is RadioButton) {
//            // Is the button now checked?
//            val checked = view.isChecked
//
//            // Check which radio button was clicked
//            when (view.getId()) {
//                R.id.radio_day ->
//                    if (checked) {
//                        println("radio_day.isChecked")
//                    }
//                R.id.radio_night ->
//                    if (checked) {
//                        println("radio_night.isChecked")
//                    }
//            }
//        }
//    }
}