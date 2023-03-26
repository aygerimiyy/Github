package com.example.github.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.github.MainActivity
import com.example.github.R
import com.example.github.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.apply {
        }
    }


    override fun onResume() {
        super.onResume()
        //(requireActivity() as MainActivity).visiblityOfBottomNavigation(View.VISIBLE)
    }
}