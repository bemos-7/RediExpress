package com.example.rediexpress.presentation.screen.account.sign_up

import android.annotation.SuppressLint
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
import com.example.rediexpress.databinding.SignUpFragmentBinding
import com.example.rediexpress.presentation.screen.account.sign_in.LoginFragment
import com.example.rediexpress.presentation.screen.account.sign_up.vm.SignUpViewModel

class SignUpFragment : Fragment() {

    lateinit var binding: SignUpFragmentBinding
    val viewModelSignUp = SignUpViewModel(App.instance.baseAuthManager)

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
                    signButton.isEnabled = checkProfile()
                }

            }

            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->

                signButton.isEnabled = checkProfile()

            }

            passwordInput.addTextChangedListener {

                val password = it.toString()

                if (passwordInput2.text.toString() != password && password.length > 6 && passwordInput2.text.toString().length > 6) {
                    passwordInput.setBackgroundResource(R.drawable.input_text_incorrect)
                    passwordInput2.setBackgroundResource(R.drawable.input_text_incorrect)
                }
                else {
                    passwordInput.setBackgroundResource(R.drawable.input_text_correct)
                    passwordInput2.setBackgroundResource(R.drawable.input_text_correct)
                    signButton.isEnabled = checkProfile()
                }
            }


            passwordInput2.addTextChangedListener {

                val password = it.toString()

                if (passwordInput.text.toString() != password && password.length > 6 && passwordInput.text.toString().length > 6) {
                    passwordInput2.setBackgroundResource(R.drawable.input_text_incorrect)
                    passwordInput.setBackgroundResource(R.drawable.input_text_incorrect)
                }
                else {
                    passwordInput2.setBackgroundResource(R.drawable.input_text_correct)
                    passwordInput.setBackgroundResource(R.drawable.input_text_correct)
                    signButton.isEnabled = checkProfile()
                }

            }


            signButton.setOnClickListener {

                if (fullNameInput.text != null || emailInput.text != null || passwordInput.text != null || passwordInput2 != null) {
                    if (passwordInput.text.toString() == passwordInput2.text.toString()) {
                        viewModelSignUp.signUp(emailInput.text.toString(), passwordInput2.text.toString(), numberInput.text.toString(), fullNameInput.text.toString())
                    }
                    else passwordInput2.setBackgroundResource(R.drawable.input_text_incorrect)
                }

            }

            loginText.setOnClickListener {

                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, LoginFragment())
                    .addToBackStack(null)
                    .commit()
            }


        }

    }

    fun checkProfile() : Boolean = with(binding) {

        return@with (passwordInput2.text.toString() == passwordInput.text.toString()) && checkBox.isChecked

    }

}
