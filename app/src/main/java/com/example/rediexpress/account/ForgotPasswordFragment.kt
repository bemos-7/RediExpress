package com.example.rediexpress.account

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.rediexpress.R
import com.example.rediexpress.databinding.ForgotPasswordFragmentBinding

class ForgotPasswordFragment : Fragment() {

    lateinit var binding: ForgotPasswordFragmentBinding

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

            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, OtpVerificationFragment())
                .commit()

        }

    }

}