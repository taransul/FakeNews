package com.example.fakenews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fakenews.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment()
    }

    private fun openFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(NewsFragment.TAG)
            .replace(R.id.placeFragment, NewsFragment.newInstance())
            .commit()
    }
}