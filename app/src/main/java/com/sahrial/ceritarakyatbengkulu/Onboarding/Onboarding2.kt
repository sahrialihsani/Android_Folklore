package com.sahrial.ceritarakyatbengkulu.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sahrial.ceritarakyatbengkulu.R
import com.sahrial.ceritarakyatbengkulu.utils.Preferences
import kotlinx.android.synthetic.main.activity_onboarding1.iv_next

class Onboarding2 : AppCompatActivity() {
    lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)


        iv_next.setOnClickListener {
            val intent = Intent(this@Onboarding2,
                Onboarding3::class.java)
            startActivity(intent)
        }
        }
    }
