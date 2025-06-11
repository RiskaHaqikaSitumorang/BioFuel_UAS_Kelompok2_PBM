package com.example.test

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.test.R

class PointActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var btnContinue: Button
    private lateinit var tvCurrentPoints: TextView

    private lateinit var option10000: LinearLayout
    private lateinit var option20000: LinearLayout
    private lateinit var option50000: LinearLayout
    private lateinit var option100000: LinearLayout
    private lateinit var option200000: LinearLayout
    private lateinit var option500000: LinearLayout

    private var selectedOption: LinearLayout? = null
    private var selectedAmount = 0
    private var selectedPoints = 0
    private var currentPoints = 16500

    // Data mapping untuk nominal dan poin
    private val amountPointsMap = mapOf(
        R.id.option_10000 to Pair(10000, 10100),
        R.id.option_20000 to Pair(20000, 20100),
        R.id.option_50000 to Pair(50000, 50100),
        R.id.option_100000 to Pair(100000, 100100),
        R.id.option_200000 to Pair(200000, 200100),
        R.id.option_500000 to Pair(500000, 500100)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point)

        initViews()
        setupClickListeners()
        updateContinueButton()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btn_back)
        btnContinue = findViewById(R.id.btn_continue)
        tvCurrentPoints = findViewById(R.id.tv_current_points)

        option10000 = findViewById(R.id.option_10000)
        option20000 = findViewById(R.id.option_20000)
        option50000 = findViewById(R.id.option_50000)
        option100000 = findViewById(R.id.option_100000)
        option200000 = findViewById(R.id.option_200000)
        option500000 = findViewById(R.id.option_500000)

        // Set current points
        tvCurrentPoints.text = "$currentPoints Poin"
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }

        btnContinue.setOnClickListener {
            if (selectedOption != null) {
                showDetailDialog()
            }
        }

        // Setup option click listeners
        val options = listOf(option10000, option20000, option50000, option100000, option200000, option500000)
        options.forEach { option ->
            option.setOnClickListener {
                selectOption(option)
            }
        }
    }

    private fun selectOption(option: LinearLayout) {
        // Reset semua option ke state unselected
        resetAllOptions()

        // Set option yang dipilih ke state selected
        selectedOption = option
        setOptionSelected(option, true)

        // Get amount dan points dari mapping
        val amountPoints = amountPointsMap[option.id]
        if (amountPoints != null) {
            selectedAmount = amountPoints.first
            selectedPoints = amountPoints.second
        }

        updateContinueButton()
    }

    private fun resetAllOptions() {
        val options = listOf(option10000, option20000, option50000, option100000, option200000, option500000)
        options.forEach { option ->
            setOptionSelected(option, false)
        }
    }

    private fun setOptionSelected(option: LinearLayout, isSelected: Boolean) {
        if (isSelected) {
            // Set selected appearance dengan outline hijau
            option.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)

            // Update text colors
            val textViews = getAllTextViews(option)
            textViews.forEach { textView ->
                textView.setTextColor(ContextCompat.getColor(this, R.color.green_primary))
            }

            // Update icon
            val imageView = getAllImageViews(option).firstOrNull()
            imageView?.setImageResource(R.drawable.ic_coins_small_green)

        } else {
            // Set unselected appearance
            option.background = ContextCompat.getDrawable(this, R.drawable.unselected_option_bg)

            // Update text colors
            val textViews = getAllTextViews(option)
            textViews.forEach { textView ->
                textView.setTextColor(ContextCompat.getColor(this, android.R.color.darker_gray))
            }

            // Update icon
            val imageView = getAllImageViews(option).firstOrNull()
            imageView?.setImageResource(R.drawable.ic_poin)
        }
    }

    private fun getAllTextViews(viewGroup: ViewGroup): List<TextView> {
        val textViews = mutableListOf<TextView>()
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is TextView) {
                textViews.add(child)
            } else if (child is ViewGroup) {
                textViews.addAll(getAllTextViews(child))
            }
        }
        return textViews
    }

    private fun getAllImageViews(viewGroup: ViewGroup): List<ImageView> {
        val imageViews = mutableListOf<ImageView>()
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is ImageView) {
                imageViews.add(child)
            } else if (child is ViewGroup) {
                imageViews.addAll(getAllImageViews(child))
            }
        }
        return imageViews
    }

    private fun updateContinueButton() {
        if (selectedOption != null && selectedPoints <= currentPoints) {
            btnContinue.isEnabled = true
            btnContinue.alpha = 1.0f
        } else {
            btnContinue.isEnabled = false
            btnContinue.alpha = 0.5f
        }
    }

    private fun showDetailDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_detail_pembayaran)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        // Setup dialog views
        val tvNominalPenarikan = dialog.findViewById<TextView>(R.id.tv_nominal_penarikan)
        val tvJumlahPoin = dialog.findViewById<TextView>(R.id.tv_jumlah_poin)
        val tvTotalPembayaran = dialog.findViewById<TextView>(R.id.tv_total_pembayaran)
        val btnKonfirmasi = dialog.findViewById<Button>(R.id.btn_confirm)
        val btnBack = dialog.findViewById<ImageView>(R.id.btn_back_dialog)

        // Set data
        tvNominalPenarikan.text = "Rp ${formatCurrency(selectedAmount)}"
        tvJumlahPoin.text = "$selectedPoints Poin"
        tvTotalPembayaran.text = "$selectedPoints Poin"

        btnBack.setOnClickListener {
            dialog.dismiss()
        }

        btnKonfirmasi.setOnClickListener {
            dialog.dismiss()
            processTransaction()
        }

        dialog.show()
    }

    private fun processTransaction() {
        // Update current points
        currentPoints -= selectedPoints
        tvCurrentPoints.text = "$currentPoints Poin"

        // Show success animation
        showSuccessAnimation()
    }

    private fun showSuccessAnimation() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_success)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)

        val ivCoins = dialog.findViewById<ImageView>(R.id.iv_coins)
        val tvSelamat = dialog.findViewById<TextView>(R.id.tv_selamat)
        val tvMessage = dialog.findViewById<TextView>(R.id.tv_message)
        val btnKembali = dialog.findViewById<Button>(R.id.btn_kembali)

        // Setup coin animation
        val scaleXAnimator = ObjectAnimator.ofFloat(ivCoins, "scaleX", 0f, 1.2f, 1f)
        val scaleYAnimator = ObjectAnimator.ofFloat(ivCoins, "scaleY", 0f, 1.2f, 1f)
        val rotationAnimator = ObjectAnimator.ofFloat(ivCoins, "rotation", 0f, 360f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator, rotationAnimator)
        animatorSet.duration = 1000

        btnKembali.setOnClickListener {
            dialog.dismiss()
            // Reset selection
            resetAllOptions()
            selectedOption = null
            updateContinueButton()
        }

        dialog.show()

        // Start animation after showing dialog
        Handler(Looper.getMainLooper()).postDelayed({
            animatorSet.start()
        }, 200)
    }

    private fun formatCurrency(amount: Int): String {
        return String.format("%,d", amount).replace(',', '.')
    }
}