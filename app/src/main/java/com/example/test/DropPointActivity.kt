package com.example.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityDropPointBinding

class DropPointActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDropPointBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout menggunakan View Binding
        binding = ActivityDropPointBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onclick listener untuk tombol back
        binding.btnBack.setOnClickListener {
            // Kembali ke DashboardActivity
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity saat ini
        }

        // Set onclick listener untuk layoutLocation1
        binding.layoutLocation1.setOnClickListener {
            // Arahkan ke MapActivity
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}