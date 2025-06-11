package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PickupDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup_detail)

        // Tombol Kembali
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack?.setOnClickListener {
            onBackPressed()
        }

        // Tombol Batalkan
        val btnBatalkan = findViewById<Button>(R.id.btn_batalkan)
        btnBatalkan?.setOnClickListener {
            onBackPressed()
        }

        // Tombol Selesai
        val btnSelesai = findViewById<Button>(R.id.btn_selesai)
        btnSelesai?.setOnClickListener {
            // Logika selesai (misalnya kembali ke DashboardActivity atau dialog sukses)
            onBackPressed()
        }
    }
}