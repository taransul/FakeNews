package com.example.fakenews.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.fakenews.R
import com.example.fakenews.presentation.recycler.News
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    private val onChooseFilter: OnChooseFilter = object : OnChooseFilter {
        override fun chooseFilter(filter: List<News>) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initRecycler()
        initFragment2()
        Log.e("my", "init********")

    }


    private fun initRecycler() {
        openFragment()

    }

    private fun initFragment2() {
        imageView.setOnClickListener {
            openFragment2()
        }
    }

    private fun openFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(Fragment.TAG)
            .replace(R.id.placeFragment, Fragment.newInstance())
            .commit()
    }

    private fun openFragment2() {


        supportFragmentManager
            .beginTransaction()
            .addToBackStack(RadioGroupFragment.TAG)
            .add(
                R.id.placeFragment,
                RadioGroupFragment.newInstance2(onChooseFilter),
                RadioGroupFragment.TAG
            )
            .commit()
    }
}
