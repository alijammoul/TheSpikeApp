package com.example.thespikeapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var adapter: SwipeAdapter
    lateinit var timer: Timer
    lateinit var facebookLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewPager = findViewById<ViewPager>(R.id.pager)

        val tabLayout = findViewById(R.id.tabDots) as TabLayout
        tabLayout.setupWithViewPager(viewPager, true)

        adapter = SwipeAdapter(this)
        viewPager.adapter = adapter
        setupAutoPager()

        facebookLoginButton = findViewById(R.id.button)
        facebookLoginButton.setOnClickListener(View.OnClickListener {
            //to implement the faceboo login process
            val mainIntent = Intent(this, ProfileActivity::class.java)
            startActivity(mainIntent)
            finish()
        })

    }

    private var currentPage = 0
    private fun setupAutoPager() {
        val handler = Handler()

        val update = Runnable {
            viewPager.setCurrentItem(currentPage, true)
            when (currentPage) {
                0 -> currentPage++
                1 -> currentPage++
                2 -> currentPage = 0
            }

        }
        timer = Timer()
        timer.schedule(object : TimerTask() {

            override fun run() {
                handler.post(update)
            }
        }, 500, 3500)//need checking with IOS developer
    }

}