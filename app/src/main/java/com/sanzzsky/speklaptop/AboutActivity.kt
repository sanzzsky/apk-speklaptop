package com.sanzzsky.speklaptop

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Setup toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Menampilkan tombol kembali di toolbar
        supportActionBar?.title = "About" // Menentukan judul toolbar

        // Referensi komponen di layout
        val imageView: ImageView = findViewById(R.id.img_creator)
        val nameTextView: TextView = findViewById(R.id.tv_creator_name)
        val emailTextView: TextView = findViewById(R.id.tv_creator_email)
        val infoTextView: TextView = findViewById(R.id.tv_creator_info)

        // Mengatur data ke komponen
        imageView.setImageResource(R.drawable.sanz_foto)
        nameTextView.text = getString(R.string.creator_name)
        emailTextView.text = getString(R.string.creator_email)
        infoTextView.text = getString(R.string.creator_info)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> { // Ketika tombol kembali ditekan
                finish() // Menutup Activity ini
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
