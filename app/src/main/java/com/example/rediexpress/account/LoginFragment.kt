package com.example.rediexpress.account

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.rediexpress.R
import com.example.rediexpress.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

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



    }

}