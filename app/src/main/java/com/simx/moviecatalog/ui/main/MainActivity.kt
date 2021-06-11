package com.simx.moviecatalog.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.simx.moviecatalog.R
import com.simx.moviecatalog.components.movie.MoviePageAdapter
import com.simx.moviecatalog.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:MainActivityBinding
    private lateinit var vm:MainVm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity)
        vm = MainVm()
        binding.lifecycleOwner = this
        binding.mainVm = vm
        binding.toolbar.title = "TMDB"
        binding.mainContainer.adapter = MoviePageAdapter(this)
        TabLayoutMediator( binding.tabs, binding.mainContainer){ tab, position ->
            when (position) {
                0 -> tab.text = "Playing Now"
                1 -> tab.text = "Top Rated"
                2 -> tab.text = "Upcoming"
                else -> tab.text = "Popular"
            }
        }.attach()
    }
}