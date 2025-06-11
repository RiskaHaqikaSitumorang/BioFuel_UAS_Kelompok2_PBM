package com.example.test

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SetorActivity : AppCompatActivity() {

    private lateinit var dropdownContainer: LinearLayout
    private lateinit var optionsContainer: LinearLayout
    private lateinit var ivDropdownArrow: ImageView
    private lateinit var btnKirim: Button
    private lateinit var tvDropdownText: TextView
    private lateinit var btnBack: ImageView

    private lateinit var btn5Liter: Button
    private lateinit var btn10Liter: Button
    private lateinit var btn15Liter: Button
    private lateinit var btn20Liter: Button
    private lateinit var btnLainnya: Button

    private var isDropdownOpen = false
    private var selectedOption: String? = null
    private var selectedButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setor)

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        dropdownContainer = findViewById(R.id.dropdownContainer)
        optionsContainer = findViewById(R.id.optionsContainer)
        ivDropdownArrow = findViewById(R.id.ivDropdownArrow)
        btnKirim = findViewById(R.id.btnKirim)
        tvDropdownText = findViewById(R.id.tvDropdownText)
        btnBack = findViewById(R.id.btn_back)

        btn5Liter = findViewById(R.id.btn5Liter)
        btn10Liter = findViewById(R.id.btn10Liter)
        btn15Liter = findViewById(R.id.btn15Liter)
        btn20Liter = findViewById(R.id.btn20Liter)
        btnLainnya = findViewById(R.id.btnLainnya)
    }

    private fun setupClickListeners() {
        dropdownContainer.setOnClickListener {
            toggleDropdown()
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btn5Liter.setOnClickListener { selectOption("5 Liter", btn5Liter) }
        btn10Liter.setOnClickListener { selectOption("10 Liter", btn10Liter) }
        btn15Liter.setOnClickListener { selectOption("15 Liter", btn15Liter) }
        btn20Liter.setOnClickListener { selectOption("20 Liter", btn20Liter) }
        btnLainnya.setOnClickListener { selectOption("Lainnya", btnLainnya) }

        btnKirim.setOnClickListener {
            showSuccessDialog()
        }

    }

    private fun toggleDropdown() {
        if (isDropdownOpen) {
            closeDropdown()
        } else {
            openDropdown()
        }
    }

    private fun openDropdown() {
        isDropdownOpen = true
        optionsContainer.visibility = View.VISIBLE

        val rotateAnimator = ObjectAnimator.ofFloat(ivDropdownArrow, "rotation", 0f, 180f)
        rotateAnimator.duration = 300
        rotateAnimator.start()

        val slideAnimator = ObjectAnimator.ofFloat(optionsContainer, "alpha", 0f, 1f)
        slideAnimator.duration = 300
        slideAnimator.start()
    }

    private fun closeDropdown() {
        isDropdownOpen = false

        val rotateAnimator = ObjectAnimator.ofFloat(ivDropdownArrow, "rotation", 180f, 0f)
        rotateAnimator.duration = 300
        rotateAnimator.start()

        val slideAnimator = ObjectAnimator.ofFloat(optionsContainer, "alpha", 1f, 0f)
        slideAnimator.duration = 300
        slideAnimator.addListener(object : android.animation.Animator.AnimatorListener {
            override fun onAnimationStart(animation: android.animation.Animator) {}
            override fun onAnimationEnd(animation: android.animation.Animator) {
                optionsContainer.visibility = View.GONE
            }
            override fun onAnimationCancel(animation: android.animation.Animator) {}
            override fun onAnimationRepeat(animation: android.animation.Animator) {}
        })
        slideAnimator.start()
    }

    private fun selectOption(option: String, button: Button) {
        selectedButton?.let { resetButtonStyle(it) }

        selectedOption = option
        selectedButton = button

        setSelectedButtonStyle(button)

        tvDropdownText.text = "Tambah Jumlah Minyak ($option)"

        closeDropdown()

        btnKirim.visibility = View.VISIBLE

        val scaleX = ObjectAnimator.ofFloat(btnKirim, "scaleX", 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(btnKirim, "scaleY", 0f, 1f)
        val alpha = ObjectAnimator.ofFloat(btnKirim, "alpha", 0f, 1f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY, alpha)
        animatorSet.duration = 300
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        animatorSet.start()
    }

    private fun setSelectedButtonStyle(button: Button) {
        button.setBackgroundResource(R.drawable.option_button_selected)
        button.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
    }

    private fun resetButtonStyle(button: Button) {
        button.setBackgroundResource(R.drawable.option_button_background)
        button.setTextColor(ContextCompat.getColor(this, R.color.text_color))
    }

    private fun showSuccessDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_success1) // Mengganti ke dialog_success1
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        val checkImageView = dialog.findViewById<ImageView>(R.id.ivCheck) // Menggunakan ivCheck
        val btnOke = dialog.findViewById<Button>(R.id.btnOke)
        val tvMessage = dialog.findViewById<TextView>(R.id.tvMessage)

        tvMessage.text = "PERMINTAAN BERHASIL DIKIRIM"

        // Animasi untuk centang
        animateCheckmark(checkImageView)

        btnOke.setOnClickListener {
            dialog.dismiss()
            resetToInitialState()
        }

        dialog.show()
    }

    private fun animateCheckmark(checkImageView: ImageView) {
        // Animasi scale up dan fade in
        val scaleX = ObjectAnimator.ofFloat(checkImageView, "scaleX", 0f, 1.2f, 1.0f)
        val scaleY = ObjectAnimator.ofFloat(checkImageView, "scaleY", 0f, 1.2f, 1.0f)
        val alpha = ObjectAnimator.ofFloat(checkImageView, "alpha", 0f, 1f)

        // Animasi rotasi ringan untuk efek hidup
        val rotation = ObjectAnimator.ofFloat(checkImageView, "rotation", -15f, 15f, 0f)

        // Bounce effect
        val bounceAnimator = ValueAnimator.ofFloat(0f, 1f)
        bounceAnimator.addUpdateListener { animator ->
            val progress = animator.animatedValue as Float
            val bounce = Math.sin(progress * Math.PI * 2).toFloat() * 0.05f
            checkImageView.translationY = bounce * 20f
        }

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY, alpha, rotation)
        animatorSet.play(bounceAnimator).with(scaleX)
        animatorSet.duration = 600
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        animatorSet.start()
    }

    private fun resetToInitialState() {
        selectedButton?.let { resetButtonStyle(it) }
        selectedButton = null
        selectedOption = null

        tvDropdownText.text = "Tambah Jumlah Minyak (L)"

        btnKirim.visibility = View.GONE

        if (isDropdownOpen) {
            closeDropdown()
        }
    }
}