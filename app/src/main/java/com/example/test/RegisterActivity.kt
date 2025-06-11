package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.example.test.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupPasswordVisibility()
        setupRegisterButton()
        setupLoginLink()
    }

    private fun setupPasswordVisibility() {
        // Password visibility toggle
        binding.ivPasswordVisibility.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(binding.etPassword, binding.ivPasswordVisibility, isPasswordVisible)
        }

        // Confirm password visibility toggle
        binding.ivConfirmPasswordVisibility.setOnClickListener {
            isConfirmPasswordVisible = !isConfirmPasswordVisible
            togglePasswordVisibility(binding.etConfirmPassword, binding.ivConfirmPasswordVisibility, isConfirmPasswordVisible)
        }
    }

    private fun togglePasswordVisibility(editText: android.widget.EditText, imageView: android.widget.ImageView, isVisible: Boolean) {
        if (isVisible) {
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            imageView.setImageResource(R.drawable.ic_visibility)
        } else {
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
            imageView.setImageResource(R.drawable.ic_visibility_off)
        }
        editText.setSelection(editText.text.length)
    }

    private fun setupRegisterButton() {
        binding.btnRegister.setOnClickListener {
            if (validateForm()) {
                registerUser()
            }
        }
    }

    private fun validateForm(): Boolean {
        val nama = binding.etNama.text.toString().trim()
        val noHp = binding.etHp.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()

        var isValid = true

        if (nama.isEmpty()) {
            binding.etNama.error = "Nama lengkap harus diisi"
            isValid = false
        }

        if (noHp.isEmpty()) {
            binding.etHp.error = "Nomor handphone harus diisi"
            isValid = false
        } else if (!noHp.matches(Regex("^[0-9]{10,13}$"))) {
            binding.etHp.error = "Format nomor handphone tidak valid"
            isValid = false
        }

        if (email.isEmpty()) {
            binding.etEmail.error = "Email harus diisi"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Format email tidak valid"
            isValid = false
        }

        if (password.isEmpty()) {
            binding.etPassword.error = "Kata sandi harus diisi"
            isValid = false
        } else if (password.length < 6) {
            binding.etPassword.error = "Kata sandi minimal 6 karakter"
            isValid = false
        }

        if (confirmPassword.isEmpty()) {
            binding.etConfirmPassword.error = "Konfirmasi kata sandi harus diisi"
            isValid = false
        } else if (password != confirmPassword) {
            binding.etConfirmPassword.error = "Kata sandi tidak cocok"
            isValid = false
        }

        return isValid
    }

    private fun registerUser() {
        // Get form values
        val nama = binding.etNama.text.toString().trim()
        val noHp = binding.etHp.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        // TODO: Implement your registration logic here
        // Example: Call API to register user

        // For demo purposes, just show a toast
        Toast.makeText(
            this,
            "Pendaftaran berhasil!\nNama: $nama\nEmail: $email",
            Toast.LENGTH_LONG
        ).show()

        // Navigate to login after successful registration
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun setupLoginLink() {
        binding.tvMasuk.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}