package net.multipul.easyfuelcalc.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import net.multipul.easyfuelcalc.R

class SplashscreenActivity : AppCompatActivity() {

    private val timeOut: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }, timeOut)
    }
}