package com.example.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.github.databinding.ActivityMainBinding
import com.example.github.ui.ExploreFragment
import com.example.github.ui.HomeFragment
import com.example.github.ui.NotificationsFragment
import com.example.github.ui.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navHostController =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostController.findNavController()
        bottomNavigationView.setupWithNavController(navController)
    }

    fun visiblityOfBottomNavigation(visiblity: Int){
        binding.bottomNavigation.visibility = visiblity
    }
}