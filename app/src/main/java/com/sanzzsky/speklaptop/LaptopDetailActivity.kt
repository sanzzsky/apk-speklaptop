package com.sanzzsky.speklaptop

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LaptopDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laptop_detail)

        // Ambil objek Laptop dari Intent
        val laptop = intent.getParcelableExtra<Laptop>("laptop")

        if (laptop != null) {
            // Referensi komponen di layout detail
            val imageView: ImageView = findViewById(R.id.img_item_photo)
            val nameTextView: TextView = findViewById(R.id.tv_item_name)
            val descTextView: TextView = findViewById(R.id.tv_item_description)
            val processorTextView: TextView = findViewById(R.id.tv_spec_processor)
            val displayTextView: TextView = findViewById(R.id.tv_spec_display)
            val batteryTextView: TextView = findViewById(R.id.tv_spec_battery)

            // Set data ke komponen
            imageView.setImageResource(laptop.imageResId)
            nameTextView.text = laptop.name
            descTextView.text = laptop.description
            processorTextView.text = laptop.specs
            displayTextView.text = laptop.displaySize
            batteryTextView.text = laptop.battery
        }
    }
}
