package com.example.rediexpress.presentation.screen.account.sign_in

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.App
import com.example.rediexpress.MainActivity
import com.example.rediexpress.R
import com.example.rediexpress.databinding.LoginFragmentBinding
import com.example.rediexpress.hash
import com.example.rediexpress.isConnectedToInternet
import com.example.rediexpress.presentation.ProfileFragment
import com.example.rediexpress.presentation.screen.account.EmptyFragment
import com.example.rediexpress.presentation.screen.account.forgot_password.ForgotPasswordFragment
import com.example.rediexpress.presentation.screen.account.sign_in.vm.LoginViewModel
import com.example.rediexpress.presentation.screen.account.sign_in.vm.UserEmailSaveViewModel
import com.example.rediexpress.presentation.screen.account.sign_up.SignUpFragment

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding
    val loginViewModel = LoginViewModel(App.instance.baseAuthManager)

    lateinit var userEmailSaveViewModel: UserEmailSaveViewModel

    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mainActivity = activity as MainActivity

        binding.signText.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, SignUpFragment())
                .commit()

        }

        binding.emailInput.addTextChangedListener {

            val text = it.toString()

            if (Patterns.EMAIL_ADDRESS.matcher(text).matches() != true) {
                binding.emailInput.setBackgroundResource(R.drawable.input_text_incorrect)
            }
            else {
                binding.emailInput.setBackgroundResource(R.drawable.input_text_correct)
            }

            binding.passwordInput.addTextChangedListener {

                val pass = it.toString()

                if (pass.length != 0 && (text.length != 0 && Patterns.EMAIL_ADDRESS.matcher(text).matches())) {
                    binding.loginButton.isEnabled = true
                } else binding.loginButton.isEnabled = false

            }

        }

        binding.forgotPasswordText.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, ForgotPasswordFragment())
                .commit()

        }
        userEmailSaveViewModel = mainActivity.userEmailSaveViewModel

        binding.loginButton.setOnClickListener {

            if (isConnectedToInternet(requireContext())) {

                loginViewModel.signIn(binding.emailInput.text.toString(), binding.passwordInput.text.toString())

                val hashPass = hash(binding.passwordInput.text.toString())

                App.hashPassword = hashPass

                userEmailSaveViewModel.email.value = binding.emailInput.text.toString()

                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, ProfileFragment())
                    .commit()

                mainActivity.binding.bottomNavItems.isVisible = true

            } else {
                Toast.makeText(requireContext(), "Отсутствует интернет соединение", Toast.LENGTH_SHORT).show()
            }

        }

        loginViewModel.stateError.observe(viewLifecycleOwner) {

            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

        }


    }

}