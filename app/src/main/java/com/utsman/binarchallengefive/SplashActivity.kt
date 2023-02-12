package com.utsman.binarchallengefive

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.utsman.binarchallengefive.databinding.ActivitySplashBinding
import com.utsman.binarchallengefive.landingpage.LandingActivity

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val imageUrl = "https://i.ibb.co/HC5ZPgD/splash-screen1.png"
        binding.imgSplash.load(imageUrl)

        /*val runnable = {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/

        Handler().postDelayed({
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}