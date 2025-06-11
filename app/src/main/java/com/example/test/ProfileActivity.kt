package com.example.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout menggunakan View Binding
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onclick listener untuk tombol logout
        binding.btnLogout.setOnClickListener {
            // Logika untuk logout (misalnya kembali ke halaman login atau keluar aplikasi)
            // Untuk contoh ini, kita akan kembali ke DashboardActivity
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish() // Menutup ProfileActivity
        }

        // Set onclick listener untuk ikon home di bottom navigation
        binding.homeIcon.setOnClickListener {
            // Kembali ke DashboardActivity
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}