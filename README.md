# **BioFuelBank**  
*Aplikasi Pengelolaan Minyak Jelantah untuk Biodiesel*  

<p align="center">
  <img src="https://github.com/user-attachments/assets/85843f60-c37b-4f1c-9e94-77c3e70f933b" alt="Logo" width="800">
</p>


## **Daftar Isi**  
1. [Deskripsi](#deskripsi)  
2. [Fitur Aplikasi](#fitur-aplikasi)  
3. [Teknologi yang Digunakan](#teknologi-yang-digunakan)  
4. [Screenshots](#screenshots)  
5. [Pengujian](#pengujian)  
6. [Instalasi](#instalasi)  
7. [Kontribusi](#kontribusi)  
8. [Lisensi](#lisensi)  

---

## **Deskripsi**  
BioFuelBank adalah aplikasi mobile yang memudahkan masyarakat, UMKM, dan restoran dalam mendaur ulang minyak jelantah menjadi biodiesel. Aplikasi ini menyediakan layanan penjemputan, drop-off di lokasi terdekat, serta sistem insentif berupa voucher atau uang tunai untuk mendorong partisipasi pengguna.  

### **Latar Belakang**  
Minyak jelantah sering dibuang sembarangan, mencemari lingkungan, dan membahayakan kesehatan. Namun, minyak ini bisa diolah menjadi biodiesel yang ramah lingkungan. BioFuelBank hadir sebagai solusi untuk mengelola minyak jelantah secara efisien.  

### **Tujuan**  
- Memudahkan pengelolaan minyak jelantah.  
- Memberikan insentif bagi pengguna.  
- Meningkatkan kesadaran daur ulang minyak jelantah.  

---

## **Fitur Aplikasi**  
| No | Fitur | Deskripsi |  
|----|-------|-----------|  
| 1 | **Pendaftaran Pengguna** | Registrasi sebagai rumah tangga, restoran, atau UMKM. |  
| 2 | **Input Data Minyak Jelantah** | Masukkan jumlah minyak (dalam liter) untuk estimasi insentif. |  
| 3 | **Sistem Insentif** | Konversi minyak jelantah menjadi voucher/uang tunai. |  
| 4 | **Penjemputan** | Penjadwalan jemput minyak (≥10 liter). |  
| 5 | **Drop-Off Terdekat** | Peta lokasi pabrik mitra untuk setor minyak. |  
| 6 | **Pelacakan Kontribusi** | Dashboard statistik minyak yang telah disetor. |  
| 7 | **Edukasi Daur Ulang** | Informasi proses pengolahan minyak jelantah menjadi biodiesel. |  

---

## **Teknologi yang Digunakan**  
| Kategori | Teknologi |  
|----------|-----------|  
| **Bahasa Pemrograman** | Kotlin |  
| **Framework** | Android Jetpack (ViewModel, LiveData, Room) |  
| **Tools** | Android Studio, Gradle, Git |  

---

## **Screenshots**  

<div align="center">
  <table>
    <!-- Row 1 -->
    <tr>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/bba075f8-80de-478b-8bb7-6dca59a623da" width="150"><br>
        <strong>Halaman Splash</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/289569a6-9200-4b4d-a4cb-7fc12aa18561" width="150"><br>
        <strong>Halaman Welcome</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/ad52e471-b770-45fe-a21f-65eb2eb1c062" width="150"><br>
        <strong>Halaman Login</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/66f1cfc7-3b8c-44ae-b327-e04218a1125a" width="150"><br>
        <strong>Halaman Register</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/5e5308d9-89c0-4013-b715-c959c68c3ff7" width="150"><br>
        <strong>Dashboard</strong>
      </td>
    </tr>
    <!-- Row 2 -->
    <tr>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/f12fe936-0165-4ac6-b41f-63a5ea294534" width="150"><br>
        <strong>Info</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/341f3955-b5f5-4e5d-a7a0-ae9a549edd76" width="150"><br>
        <strong>Setor Minyak</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/69e36c69-0df6-4ee3-a6d0-36ee18743497" width="150"><br>
        <strong>Drop Point</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/ab0282c7-515d-40c6-a057-dae802cbbfd9" width="150"><br>
        <strong>PickUp</strong>
      </td>
      <td align="center">
        <img src="https://github.com/user-attachments/assets/508c2788-a7d9-4f37-a360-fbda4775845a" width="150"><br>
        <strong>Tukar Poin</strong>
      </td>
    </tr>
  </table>
</div>



---

## **Pengujian**  
| No | Fitur | Status | Keterangan |  
|----|-------|--------|------------|  
| 1 | Pendaftaran & Login | ✅ Berhasil | Verifikasi berjalan  |  
| 2 | Input Minyak Jelantah | ✅ Berhasil | Estimasi insentif terhitung otomatis |  
| 3 | Penjemputan | ✅ Berhasil | Notifikasi jadwal muncul di aplikasi |  
| 4 | Drop-Off | ✅ Berhasil | Peta dan rute tampil dengan benar |  
| 5 | Penukaran Insentif | ✅ Berhasil | Voucher/uang tunai berhasil diterima |  

---

## **Instalasi**  
### **Persyaratan**  
- Android Studio (Versi terbaru)  
- Android SDK (API 24+)  
- Firebase Project (untuk autentikasi & database)  

### **Langkah-Langkah**  
1. **Clone Repository**  
   ```bash
   git clone https://github.com/RiskaHaqikaSitumorang/BioFuel_UAS_Kelompok2_PBM.git
   cd BioFuel
   ```  
2. **Buka di Android Studio**  
   - File → Open → Pilih folder project  
3. **Konfigurasi Firebase**  
   - Tambahkan file `google-services.json` ke folder `app/`  
4. **Build & Run**  
   - Tekan **Run** (Shift + F10)  

---

## **Kontribusi**  
1. Fork repository  
2. Buat branch baru (`git checkout -b fitur-baru`)  
3. Commit perubahan (`git commit -m "Tambahkan fitur X"`)  
4. Push ke branch (`git push origin fitur-baru`)  
5. Buat Pull Request  

---

## **Lisensi**  
[MIT License](https://opensource.org/licenses/MIT)  

---

**© 2024 BioFuelBank | Dikembangkan oleh [Riska Haqika Situmorang & Nazwa Salsabila]** 🚀
