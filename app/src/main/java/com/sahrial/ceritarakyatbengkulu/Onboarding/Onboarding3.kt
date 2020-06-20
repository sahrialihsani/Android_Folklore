package com.sahrial.ceritarakyatbengkulu.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sahrial.ceritarakyatbengkulu.HalamanUtamaActivity
import com.sahrial.ceritarakyatbengkulu.R
import kotlinx.android.synthetic.main.activity_onboarding3.*

class Onboarding3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding3)

        iv_next.setOnClickListener {
            finishAffinity()

            val intent = Intent(this@Onboarding3,
                HalamanUtamaActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Selamat Datang", Toast.LENGTH_LONG).show()
        }
    }
}
