package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout menggunakan View Binding
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onclick listener untuk layoutInfo
        binding.layoutInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        // Set onclick listener untuk layoutdroppoint
        binding.layoutdroppoint.setOnClickListener {
            val intent = Intent(this, DropPointActivity::class.java)
            startActivity(intent)
        }

        // Set onclick listener untuk layoutRiwayat
        binding.layoutRiwayat.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        // Set onclick listener untuk profileIcon di bottom navigation
        binding.profileIcon.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Set onclick listener untuk tombol tukarpoint
        binding.tukarpoint.setOnClickListener {
            val intent = Intent(this, PointActivity::class.java)
            startActivity(intent)
        }

        // Set onclick listener untuk addoil di bottom navigation
        binding.addoil?.setOnClickListener {
            val intent = Intent(this, SetorActivity::class.java)
            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Gagal membuka SetorActivity: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        } ?: run {
            Toast.makeText(this, "Elemen addoil tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }
}