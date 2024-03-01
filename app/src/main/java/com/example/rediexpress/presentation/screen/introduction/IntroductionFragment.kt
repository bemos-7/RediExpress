package com.example.rediexpress.presentation.screen.introduction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.rediexpress.App
import com.example.rediexpress.R
import com.example.rediexpress.presentation.screen.account.sign_in.LoginFragment
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

        with(binding) {

//            val firstItem = items.removeLast()
//
//            anotherImage.setImageResource(firstItem.image)
//            anotherTextFirst.text = firstItem.title
//            anotherTextFirst2.text = firstItem.description
//
//
//            nextBt.setOnClickListener {
//
//                if (!items.isEmpty()) {
//
//                    val item = items.removeLast()
//
//                    anotherImage.setImageResource(item.image)
//                    anotherTextFirst.text = item.title
//                    anotherTextFirst2.text = item.description
//
//                    if (items.isEmpty()) {
//
//                        signUpBt.visibility = View.VISIBLE
//                        signUpBt.isEnabled = true
//
//                        skipBt.visibility = View.INVISIBLE
//                        nextBt.visibility = View.INVISIBLE
//
//                        textTv.visibility = View.VISIBLE
//                        textTv2.visibility = View.VISIBLE
//
//                    }
//
//                }

//            }

//            skipBt.setOnClickListener {
//                parentFragmentManager.beginTransaction().replace(R.id.frame_container, LoginFragment()).commit()
//            }
//
//            signUpBt.setOnClickListener {
//
//                parentFragmentManager.beginTransaction().replace(R.id.frame_container, SignUpFragment()).addToBackStack(null).commit()
//
//            }
//
//            textTv2.setOnClickListener {
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.frame_container, LoginFragment())
//                    .addToBackStack(null)
//                    .commit()
//            }

        }


    }

}