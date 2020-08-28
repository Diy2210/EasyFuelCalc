package net.multipul.easyfuelcalc.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import net.multipul.easyfuelcalc.R
import net.multipul.easyfuelcalc.model.SettingsModel
import kotlin.properties.Delegates

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    private var theme by Delegates.notNull<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)

        root.radioTheme.setOnCheckedChangeListener { _, i ->
            if (i == R.id.radio_day) {
//                theme = false
                theme = "radio_day"
                SettingsModel(theme)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else if (i == R.id.radio_night) {
//                theme = true
                theme = "radio_night"
                SettingsModel(theme)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

//        val s = SettingsModel(theme)
//        if (s.equals("radio_day")) {
//            println("radio_day.isChecked")
//        } else {
//            println("radio_night.isChecked")
//        }

        return root
    }
}