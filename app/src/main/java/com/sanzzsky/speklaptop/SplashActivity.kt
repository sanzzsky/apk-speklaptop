package com.sanzzsky.speklaptop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menggunakan Handler untuk delay sebelum pindah ke MainActivity
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Menutup SplashActivity agar tidak bisa kembali
        }, 2000) // 2000 ms = 2 detik
    }
}
