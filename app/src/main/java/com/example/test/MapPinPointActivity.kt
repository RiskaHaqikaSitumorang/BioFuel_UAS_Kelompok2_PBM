package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MapPinpointActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_pinpoint)

        // Tombol Kembali
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack?.setOnClickListener {
            onBackPressed()
        } ?: run {
            Toast.makeText(this, "Tombol Kembali tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        // Tombol Simpan
        val btnSimpan = findViewById<Button>(R.id.btn_simpan)
        btnSimpan?.setOnClickListener {
            // Ambil data alamat dari UI
            val address = findViewById<TextView>(R.id.tv_address)?.text.toString()
            val addressDetail = findViewById<TextView>(R.id.tv_address_detail)?.text.toString()

            if (address.isNotEmpty() && addressDetail.isNotEmpty()) {
                // Buat Intent ke PickupDetailActivity dan kirim data
                val intent = Intent(this, PickupDetailActivity::class.java).apply {
                    putExtra("address", address)
                    putExtra("address_detail", addressDetail)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Alamat belum diatur", Toast.LENGTH_SHORT).show()
            }
        } ?: run {
            Toast.makeText(this, "Tombol Simpan tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        // Tombol Cari (opsional, bisa diimplementasikan untuk interaksi map)
        val btnCari = findViewById<Button>(R.id.btn_cari)
        btnCari?.setOnClickListener {
            Toast.makeText(this, "Fitur cari belum diimplementasikan", Toast.LENGTH_SHORT).show()
            // Tambahkan logika untuk pencarian di peta
        } ?: run {
            Toast.makeText(this, "Tombol Cari tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }
}