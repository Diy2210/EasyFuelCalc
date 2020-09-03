package net.multipul.easyfuelcalc

import android.app.Application

class App : Application() {

    lateinit var theme: String

    override fun onCreate() {
        super.onCreate()
        theme = "radio_day"
    }
}
