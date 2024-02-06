package com.example.rediexpress.presentation.screen.introduction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.rediexpress.R
import com.example.rediexpress.presentation.screen.account.LoginFragment
import com.example.rediexpress.presentation.screen.account.sign_up.SignUpFragment
import com.example.rediexpress.databinding.IntroductionFragmentBinding

class IntroductionFragment : Fragment() {

    lateinit var binding: IntroductionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = IntroductionFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var count = 0

        with(binding) {

            nextBt.setOnClickListener {

                if (count == 0) {
                    anotherImage.setImageResource(com.example.rediexpress.R.drawable._123)
                    anotherTextFirst.text = "Flexible Payment"
                    anotherTextFirst2.text = "Different modes of payment either before and after delivery without stress"
                    count++
                }
                else {
                    anotherImage.setImageResource(com.example.rediexpress.R.drawable.rafiki)
                    anotherTextFirst.text = "Real-time Tracking"
                    anotherTextFirst2.text = "Track your packages/items from the comfort of your home till final destination"
                    nextBt.isEnabled = false
                    skipBt.isEnabled = false
                    nextBt.isInvisible = true
                    skipBt.isInvisible = true
                    signUpBt.isVisible = true
                    signUpBt.isEnabled = true
                    textTv.isVisible = true
                    textTv2.isVisible = true
                    count++
                }
            }

            skipBt.setOnClickListener {
                anotherImage.setImageResource(com.example.rediexpress.R.drawable.rafiki)
                anotherTextFirst.text = "Real-time Tracking"
                anotherTextFirst2.text = "Track your packages/items from the comfort of your home till final destination"
                nextBt.isEnabled = false
                skipBt.isEnabled = false
                nextBt.isInvisible = true
                skipBt.isInvisible = true
                signUpBt.isVisible = true
                signUpBt.isEnabled = true
                textTv.isVisible = true
                textTv2.isVisible = true
            }

            signUpBt.setOnClickListener {

                parentFragmentManager.beginTransaction().replace(R.id.frame_container, SignUpFragment()).addToBackStack(null).commit()

            }

            textTv2.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, LoginFragment())
                    .addToBackStack(null)
                    .commit()
            }

        }


    }

}