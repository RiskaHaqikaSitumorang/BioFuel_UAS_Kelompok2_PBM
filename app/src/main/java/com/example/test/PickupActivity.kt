package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PickupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup)

        // Tombol Kembali
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack?.setOnClickListener {
            onBackPressed()
        } ?: run {
            Toast.makeText(this, "Tombol Kembali tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        // Tombol Tambah Alamat
        val btnTambahAlamat = findViewById<TextView>(R.id.btn_tambah_alamat)
        btnTambahAlamat?.setOnClickListener {
            val intent = Intent(this, AddAddressActivity::class.java)
            startActivity(intent)
        } ?: run {
            Toast.makeText(this, "Tombol Tambah Alamat tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        // Pilih Jadwal
        val llPilihJadwal = findViewById<LinearLayout>(R.id.ll_pilih_jadwal)
        llPilihJadwal?.setOnClickListener {
            Toast.makeText(this, "Fitur pilih jadwal belum diimplementasikan", Toast.LENGTH_SHORT).show()
            // Tambahkan logika untuk memilih jadwal (misalnya dialog atau activity baru) di sini
        } ?: run {
            Toast.makeText(this, "Elemen Pilih Jadwal tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        // Tombol Konfirmasi
        val btnKonfirmasi = findViewById<Button>(R.id.btn_konfirmasi)
        btnKonfirmasi?.setOnClickListener {
            Toast.makeText(this, "Konfirmasi hanya aktif jika alamat dan jadwal dipilih", Toast.LENGTH_SHORT).show()
            // Logika konfirmasi (misalnya ke PickupDetailActivity) bisa ditambahkan setelah validasi
        } ?: run {
            Toast.makeText(this, "Tombol Konfirmasi tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }
}