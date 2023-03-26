package com.example.github.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.github.R
import com.example.github.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay

class SplashFragment:Fragment(R.layout.fragment_splash) {
    lateinit var binding: FragmentSplashBinding
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        navController = Navigation.findNavController(view)

        binding.apply {
            lifecycleScope.launchWhenCreated {
                delay(2000)
                navController.navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            }
        }

    }
}