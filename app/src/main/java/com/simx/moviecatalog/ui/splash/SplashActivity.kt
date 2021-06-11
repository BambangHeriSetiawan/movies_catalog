package com.simx.moviecatalog.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.simx.moviecatalog.R
import com.simx.moviecatalog.databinding.SplashActivityBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding:SplashActivityBinding
    private lateinit var vm:SplashVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.splash_activity)
        vm = SplashVM()
        binding.lifecycleOwner = this
        binding.splashVm = vm


    }
}