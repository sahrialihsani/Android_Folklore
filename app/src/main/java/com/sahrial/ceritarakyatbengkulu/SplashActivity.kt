package com.sahrial.ceritarakyatbengkulu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sahrial.ceritarakyatbengkulu.Onboarding.Onboarding1

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashActivity,
                Onboarding1::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}
