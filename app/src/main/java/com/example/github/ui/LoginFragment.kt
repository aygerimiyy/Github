package com.example.github.ui

import android.content.Intent
import android.net.Uri
import android.o//s.Binder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.github.R
import com.example.github.databinding.FragmentLoginBinding
import com.example.github.presentation.UserVM
import com.example.github.utils.ResourceState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    lateinit var binding: FragmentLoginBinding
    lateinit var navController: NavController

    private val vm: UserVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)
        navController = Navigation.findNavController(view)

        initListener()
        setUpObservers()
    }

    private fun initListener() {
        binding.apply {
            btnSignInWith.setOnClickListener {
                vm.user()
                /*val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/login/oauth/authorize?client_id=8f3cf5f09bd0c93a0528&scope=repo")
                )
                startActivity(intent)*/

            }
        }
    }

    private fun setUpObservers() {
        vm.user.observe(viewLifecycleOwner) {
            when (it.status) {
                ResourceState.LOADING -> {

                }
                ResourceState.SUCCESS -> {
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                }
                ResourceState.ERROR -> {
                    Log.d("qalay", it.message.toString())
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()

        val uri: Uri? = requireActivity().intent?.data
        if (uri != null) {
            val code = uri.getQueryParameter("code")
            if (code != null) {
                Toast.makeText(requireContext(), "Login success: $code", Toast.LENGTH_SHORT).show()
                lifecycleScope.launchWhenResumed {

                }
            }
        }
    }
}