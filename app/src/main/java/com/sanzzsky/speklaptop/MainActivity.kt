package com.sanzzsky.speklaptop

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var rvLaptop: RecyclerView
    private val laptopList = ArrayList<Laptop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvLaptop = findViewById(R.id.rv_laptop)
        rvLaptop.setHasFixedSize(true)

        laptopList.addAll(getLaptopData()) // Mengisi data laptop
        showRecyclerList() // Menampilkan RecyclerView
    }

    // Menambahkan opsi menu ke Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Menangani klik pada item menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                // Navigasi ke halaman About
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getLaptopData(): ArrayList<Laptop> {
        // Mengambil data dari string-array
        val names = resources.getStringArray(R.array.laptop_names)
        val descriptions = resources.getStringArray(R.array.laptop_descriptions)
        val specs = resources.getStringArray(R.array.laptop_specs)
        val displaySizes = resources.getStringArray(R.array.laptop_display_sizes)
        val batteryCapacities = resources.getStringArray(R.array.laptop_battery_capacity)
        val imageResIds = resources.obtainTypedArray(R.array.laptop_images)

        // Membuat daftar laptop
        val laptops = ArrayList<Laptop>()
        for (i in names.indices) {
            val laptop = Laptop(
                name = names[i],
                description = descriptions[i],
                specs = specs[i],
                displaySize = displaySizes[i],
                battery = batteryCapacities[i],
                imageResId = imageResIds.getResourceId(i, -1)
            )
            laptops.add(laptop)
        }
        imageResIds.recycle()
        return laptops
    }


    private fun showRecyclerList() {
        rvLaptop.layoutManager = LinearLayoutManager(this)

        // Membuat dan menetapkan adapter
        val listLaptopAdapter = ListLaptopAdapter(laptopList) { selectedLaptop ->
            // Menangani klik item
            val intent = Intent(this, LaptopDetailActivity::class.java)
            intent.putExtra("laptop", selectedLaptop)  // Mengirim objek Laptop ke LaptopDetailActivity
            startActivity(intent)
        }

        rvLaptop.adapter = listLaptopAdapter // Mengatur adapter ke RecyclerView
    }
}
