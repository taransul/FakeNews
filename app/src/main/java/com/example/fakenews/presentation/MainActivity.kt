package com.example.fakenews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fakenews.R
import com.example.fakenews.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by viewBinding()

    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        openFragment()

        binding.floatingActionButtonLoad.setOnClickListener {
            userViewModel.loadNews()
        }
        binding.floatingActionButtonInsert.setOnClickListener {
            userViewModel.insertNews()
        }
//        userViewModel.users.observe(this) { users ->
//            Log.e("my", users.toString())
//        }
    }


    private fun openFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(NewsFragment.TAG)
            .replace(R.id.placeFragment, NewsFragment.newInstance())
            .commit()
    }
}