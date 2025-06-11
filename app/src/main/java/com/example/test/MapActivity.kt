package com.example.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout menggunakan View Binding
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onclick listener untuk tombol back
        binding.btnBack.setOnClickListener {
            // Kembali ke DropPointActivity
            val intent = Intent(this, DropPointActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity saat ini
        }
    }
}