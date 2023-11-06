package com.example.tugasbuah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasbuah.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapterBuah = BuahAdapter(generateBuahData()){
            buah ->
            Toast.makeText(this@MainActivity, "Ini adalah buah ${buah.nama}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvBuah.apply {
                adapter = adapterBuah
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
    fun generateBuahData (): List<Buah> {
       return listOf(
           Buah(imageResId = R.drawable.appleicon, nama = "Apel", warna = "Merah"),
           Buah(imageResId = R.drawable.grapeicon, nama = "Anggur", warna = "Ungu"),
           Buah(imageResId = R.drawable.orangeicon, nama = "Jeruk", warna = "Oranye"),
           Buah(imageResId = R.drawable.strawberryicon, nama = "Strawberry", warna = "Merah"))
    }
}