package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddAddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)

        // Tombol Kembali
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack?.setOnClickListener {
            onBackPressed()
        } ?: run {
            Toast.makeText(this, "Tombol Kembali tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        // Atur Berdasarkan Pinpoint
        val llPinpoint = findViewById<LinearLayout>(R.id.ll_pinpoint)
        llPinpoint?.setOnClickListener {
            val intent = Intent(this, MapPinpointActivity::class.java)
            startActivity(intent)
        } ?: run {
            Toast.makeText(this, "Elemen Pinpoint tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }
}