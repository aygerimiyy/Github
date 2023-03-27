package com.example.github.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.github.R
import com.example.github.data.localStorage.LocalStorage
import com.example.github.databinding.FragmentLoginBinding
import com.example.github.presentation.MainViewModel
<<<<<<< Updated upstream
import com.example.github.utils.toast
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
=======
import com.example.github.presentation.UserVM
import com.example.github.utils.ResourceState
import com.example.github.utils.toast
>>>>>>> Stashed changes
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModel<MainViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        initListeners()
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    }

    private fun initListeners() {
        binding.apply {
<<<<<<< Updated upstream
            btnSignInWith.setOnClickListener {
=======
            //tilUrl.visibility = View.GONE
            //etUrl.visibility = View.GONE
            //signIn.visibility = View.GONE
            enterpriseText.visibility = View.GONE
            signInEnterprise.visibility = View.VISIBLE
            signInWith.visibility = View.VISIBLE

            signInWith.setOnClickListener {
>>>>>>> Stashed changes
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/login/oauth/authorize?client_id=8f3cf5f09bd0c93a0528&scope=repo")
                )
                startActivity(intent)
            }

<<<<<<< Updated upstream
            btnSignInEnterprise.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignInfragment())
=======
            signInEnterprise.setOnClickListener {
                signInWith.visibility = View.GONE
                signInEnterprise.visibility = View.GONE
                tilUrl.visibility = View.VISIBLE
                etUrl.visibility = View.VISIBLE
                signIn.visibility = View.VISIBLE
                enterpriseText.visibility = View.VISIBLE
>>>>>>> Stashed changes
            }

        }
    }
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    override fun onResume() {
        super.onResume()
        val uri: Uri? = requireActivity().intent?.data
        if (uri != null) {
            val code = uri.getQueryParameter("code")
            if (code != null) {
                //get Access Token zapros ketedi codedi alg'annan son'
                toast("Login success: $code")
                lifecycleScope.launchWhenResumed {
                    viewModel.getAccessToken(code)
                }
                findNavController().navigate(
<<<<<<< Updated upstream
                    LoginFragmentDirections.actionLoginFragmentToMainFragment()
=======
                    LoginFragmentDirections.actionLoginFragmentToHomeFragment()
>>>>>>> Stashed changes
                )
            } else if ((uri.getQueryParameter("error")) != null) {
                toast("Something went wrong!")
            }
            initObservers()
        }

<<<<<<< Updated upstream
=======
    }

    private fun initObservers() {
        viewModel.getAccessTokenFlow.onEach {
            LocalStorage().isLog = true
            LocalStorage().token = it.access_token
        }.launchIn(lifecycleScope)

        viewModel.messageFlow.onEach {
            toast("Token kelmey qaldi")
        }.launchIn(lifecycleScope)
>>>>>>> Stashed changes
    }

    private fun initObservers() {
        viewModel.getAccessTokenFlow.onEach {
            LocalStorage().isLog = true
            LocalStorage().token = it.access_token
        }.launchIn(lifecycleScope)

        viewModel.messageFlow.onEach {
            toast("Token kelmey qaldi")
        }.launchIn(lifecycleScope)
    }



}