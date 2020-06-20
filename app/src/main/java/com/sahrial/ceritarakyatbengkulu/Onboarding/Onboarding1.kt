package com.sahrial.ceritarakyatbengkulu.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sahrial.ceritarakyatbengkulu.HalamanUtamaActivity
import com.sahrial.ceritarakyatbengkulu.R
import com.sahrial.ceritarakyatbengkulu.utils.Preferences
import kotlinx.android.synthetic.main.activity_onboarding1.*

class Onboarding1 : AppCompatActivity() {
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        preferences = Preferences(this)

        if (preferences.getValues("onboarding").equals("1")) {
            finishAffinity()

            val intent = Intent(this@Onboarding1,
                HalamanUtamaActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Selamat Datang", Toast.LENGTH_LONG).show()
        }
        iv_next.setOnClickListener {
            preferences.setValues("onboarding", "1")
            finishAffinity()

            val intent = Intent(this@Onboarding1,
                Onboarding2::class.java)
            startActivity(intent)
        }


    }
}