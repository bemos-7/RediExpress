package com.example.rediexpress.account

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.rediexpress.R
import com.example.rediexpress.databinding.SignUpFragmentBinding
import java.util.regex.Pattern

class SignUpFragment : Fragment() {

    lateinit var binding: SignUpFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {

            numberInput.addTextChangedListener {

                val text = it.toString()

                if (Patterns.PHONE.matcher(text).matches() != true) {
                    numberInput.setBackgroundResource(R.drawable.input_text_incorrect)
                }
                else {
                    numberInput.setBackgroundResource(R.drawable.input_text_correct)
                }

            }

            emailInput.addTextChangedListener {

                val text = it.toString()

                if (Patterns.EMAIL_ADDRESS.matcher(text).matches() != true) {
                    emailInput.setBackgroundResource(R.drawable.input_text_incorrect)
                }
                else {
                    emailInput.setBackgroundResource(R.drawable.input_text_correct)
                }

            }

            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->

                signButton.isEnabled = true

            }

            passwordInput2.addTextChangedListener {

                val pass = it.toString()

                if (passwordInput.text.toString() != pass) {
                    passwordInput2.setBackgroundResource(R.drawable.input_text_incorrect)
                }
                else passwordInput2.setBackgroundResource(R.drawable.input_text_correct)

            }


            signButton.setOnClickListener {

                if (fullNameInput.text != null || emailInput.text != null || passwordInput.text != null || passwordInput2 != null) {
                    if (passwordInput.text.toString() == passwordInput2.text.toString()) {
                        parentFragmentManager
                    }
                    else passwordInput2.setBackgroundResource(R.drawable.input_text_incorrect)
                }

            }

            loginText.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, LoginFragment())
                    .commit()
            }


        }

    }

}
