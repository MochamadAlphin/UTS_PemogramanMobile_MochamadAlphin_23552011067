package com.example.uts_project_medicipaw

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.graphics.Color
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SplashActivity234 : AppCompatActivity() {

    private lateinit var splashImage: ImageView
    private lateinit var nextButton: Button
    private lateinit var indicatorLayout: LinearLayout

    private val images = intArrayOf(R.drawable.splash_screen2, R.drawable.splash_screen3, R.drawable.splash_screen4)
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen234)

        splashImage = findViewById(R.id.splash_image)
        nextButton = findViewById(R.id.next_button)
        indicatorLayout = findViewById(R.id.indicator)

        createIndicators(images.size)
        splashImage.setImageResource(images[currentIndex])
        updateIndicators(currentIndex)

        nextButton.setOnClickListener {
            if (currentIndex < images.size - 1) {
                currentIndex++
                animateSplashScreen()
                updateIndicators(currentIndex)
            } else {
                // Ganti ke LoginActivity
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    private fun animateSplashScreen() {
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        val backgroundView: View = findViewById(R.id.background_view)

        splashImage.startAnimation(fadeOut)

        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                backgroundView.setBackgroundColor(Color.parseColor("#fff7f4"))
            }

            override fun onAnimationEnd(animation: Animation?) {
                splashImage.setImageResource(images[currentIndex])
                splashImage.startAnimation(fadeIn)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }

    private fun createIndicators(count: Int) {
        indicatorLayout.removeAllViews()
        for (i in 0 until count) {
            val indicator = ImageView(this)
            indicator.setImageResource(R.drawable.circle_inactive)
            val params = LinearLayout.LayoutParams(
                24, // Ukuran untuk tidak aktif (width)
                24  // Ukuran untuk tidak aktif (height)
            )
            params.setMargins(12, 0, 12, 0) // Tambah margin agar tidak terlalu rapat
            indicatorLayout.addView(indicator, params)
        }
    }

    private fun updateIndicators(position: Int) {
        for (i in 0 until indicatorLayout.childCount) {
            val indicator = indicatorLayout.getChildAt(i) as ImageView
            if (i == position) {
                // Indikator aktif lebih besar
                indicator.layoutParams.width = 36 // Ukuran baru untuk aktif
                indicator.layoutParams.height = 36 // Ukuran baru untuk aktif
                indicator.setImageResource(R.drawable.circle_active)
            } else {
                // Indikator tidak aktif
                indicator.layoutParams.width = 24 // Ukuran untuk tidak aktif
                indicator.layoutParams.height = 24 // Ukuran untuk tidak aktif
                indicator.setImageResource(R.drawable.circle_inactive)
            }
            indicator.requestLayout() // Meminta layout ulang untuk memperbarui tampilan
        }
    }
}