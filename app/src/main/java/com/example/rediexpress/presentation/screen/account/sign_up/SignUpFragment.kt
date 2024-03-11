package com.example.rediexpress.presentation.screen.account.sign_up

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import com.example.rediexpress.data.passwordHash.MainViewModel
import com.example.rediexpress.databinding.SignUpFragmentBinding
import com.example.rediexpress.hash
import com.example.rediexpress.isConnectedToInternet
import com.example.rediexpress.presentation.ProfileFragment
import com.example.rediexpress.presentation.screen.account.sign_in.LoginFragment
import com.example.rediexpress.presentation.screen.account.sign_up.vm.SignUpViewModel

class SignUpFragment : Fragment() {

    lateinit var binding: SignUpFragmentBinding
    val viewModelSignUp = SignUpViewModel(App.instance.baseAuthManager)

    lateinit var mainActivity: MainActivity

    lateinit var passwordSave: MainViewModel

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

        mainActivity = activity as MainActivity

        passwordSave = mainActivity.mainViewModelPass

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
                        val isNetworkAvaible = isConnectedToInternet(requireContext())
                        if (isNetworkAvaible) {
                            viewModelSignUp.signUp(emailInput.text.toString(), passwordInput2.text.toString(), numberInput.text.toString(), fullNameInput.text.toString())

                            val hashPass = hash(binding.passwordInput2.text.toString())

                            passwordSave.set(hashPass)
                            passwordSave.get()

                            passwordSave.state.observe(viewLifecycleOwner) {

                                Log.d("passwordKey", it)

                            }


                            App.hashPassword = hashPass

                        } else Toast.makeText(context, "internet connection invalid", Toast.LENGTH_SHORT).show()

                    }
                    else passwordInput2.setBackgroundResource(R.drawable.input_text_incorrect)
                }

                parentFragmentManager.beginTransaction().replace(R.id.frame_container, LoginFragment()).commit()

                mainActivity.binding.bottomNavItems.isVisible = true

            }

            viewModelSignUp.stateError.observe(viewLifecycleOwner) {

                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()

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
