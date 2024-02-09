package com.example.rediexpress.presentation.screen.account.forgot_password

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.App
import com.example.rediexpress.R
import com.example.rediexpress.databinding.ForgotPasswordFragmentBinding
import com.example.rediexpress.presentation.screen.account.OtpVerificationFragment
import com.example.rediexpress.presentation.screen.account.sign_up.SignUpFragment
import com.example.rediexpress.presentation.screen.account.forgot_password.vm.ForgotPasswordViewModel

class ForgotPasswordFragment : Fragment() {

    lateinit var binding: ForgotPasswordFragmentBinding
    val viewModelForgotPassword = ForgotPasswordViewModel(App.instance.baseAuthManager)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ForgotPasswordFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.emailInput.addTextChangedListener {

            var email = it.toString()

            if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.length != 0) {
                binding.sendButton.isEnabled = true
            } else  binding.sendButton.isEnabled = false

        }

        binding.signText.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, SignUpFragment())
                .commit()

        }

        binding.sendButton.setOnClickListener {

            viewModelForgotPassword.forgotPass(binding.emailInput.text.toString())

            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, OtpVerificationFragment())
                .commit()

        }

    }

}