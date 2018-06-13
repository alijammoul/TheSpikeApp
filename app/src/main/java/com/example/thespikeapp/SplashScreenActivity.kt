package com.example.thespikeapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

import android.view.animation.AnimationUtils
import android.widget.TextView import android.view.animation.Animation

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var spikeLogo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        spikeLogo = findViewById(R.id.logo)


        val animation = AnimationUtils.loadAnimation(this,
                R.anim.animation_splashscreen)


        spikeLogo.startAnimation(animation)

        Handler().postDelayed({
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 1800)
    }
}