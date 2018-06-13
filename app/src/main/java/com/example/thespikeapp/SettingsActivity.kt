package com.example.thespikeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SettingsActivity : AppCompatActivity() {
   private lateinit var mainToolbar :android.support.v7.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        mainToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(mainToolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false);
    }
}
