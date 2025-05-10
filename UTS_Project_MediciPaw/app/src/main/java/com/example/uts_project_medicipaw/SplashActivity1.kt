package com.example.uts_project_medicipaw

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity1 : AppCompatActivity() {

    private lateinit var splashImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen1)

        splashImage = findViewById(R.id.splash_image)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splashImage.startAnimation(fadeIn)

        Handler().postDelayed({
            startSecondSplashScreen()
        }, 3000)
    }

    private fun startSecondSplashScreen() {
        val intent = Intent(this, SplashActivity234::class.java)
        startActivity(intent)
        finish()
    }
}