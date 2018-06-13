package com.example.thespikeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.R.menu
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar


class ProfileActivity : AppCompatActivity() {

lateinit var mainToolbar :android.support.v7.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        mainToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(mainToolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false);

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.settingsbutton) {
            val mainIntent = Intent(this, SettingsActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
