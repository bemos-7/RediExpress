package com.example.rediexpress.presentation.screen.account.forgot_password

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.App
import com.example.rediexpress.MainActivity
import com.example.rediexpress.R
import com.example.rediexpress.databinding.ForgotPasswordFragmentBinding
import com.example.rediexpress.isConnectedToInternet
import com.example.rediexpress.presentation.screen.account.OtpVerificationFragment
import com.example.rediexpress.presentation.screen.account.sign_up.SignUpFragment
import com.example.rediexpress.presentation.screen.account.forgot_password.vm.ForgotPasswordViewModel
import com.example.rediexpress.presentation.screen.account.forgot_password.vm.SaveEmailForOTP

class ForgotPasswordFragment : Fragment() {

    lateinit var binding: ForgotPasswordFragmentBinding
    val viewModelForgotPassword = ForgotPasswordViewModel(App.instance.baseAuthManager)

    lateinit var saveEmailForOTP: SaveEmailForOTP
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

        val mainActivity = activity as MainActivity

        saveEmailForOTP = mainActivity.saveEmailForOTP

        binding.sendButton.setOnClickListener {
            
            if (isConnectedToInternet(requireContext())) {

                viewModelForgotPassword.forgotPass(binding.emailInput.text.toString())

                saveEmailForOTP.emailSave.value = binding.emailInput.text.toString()

                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, OtpVerificationFragment())
                    .commit()
                
            } else {
                Toast.makeText(requireContext(), "Отсутствует интернет соединение", Toast.LENGTH_SHORT).show()
            }



        }
        
        viewModelForgotPassword.stateError.observe(viewLifecycleOwner) {

            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            
        }

    }

}