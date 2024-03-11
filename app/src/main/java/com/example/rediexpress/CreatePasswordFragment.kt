package com.example.rediexpress

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.rediexpress.databinding.CreatePasswordFragmentBinding
import com.example.rediexpress.databinding.HomeFragmentBinding

class CreatePasswordFragment : Fragment() {

    lateinit var binding: CreatePasswordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CreatePasswordFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var password = StringBuilder()
        var passFull = false

        with(binding) {

//            passOne.setOnClickListener {
//
//                if (password.length == 4) {
//                    isTrueVisibility(true, almostDoneText, repeatPassword)
//                } else {
//                    password.append(passOne.text.toString())
////                    password.deleteAt(password.length - 1)
//                }
//
//
//            }


            passOne.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passOne.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passTwo.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passTwo.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passThree.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passThree.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passFour.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passFour.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passFive.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passFive.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passSix.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passSix.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passSeven.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passSeven.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passEight.setOnClickListener {
                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passEight.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

            passNine.setOnClickListener {

                if (password.length == 4) {

                    isTrueVisibility(true, almostDoneText, repeatPassword)

                } else {
                    password.append(passNine.text.toString())
                }

                Log.d("passNumeric", password.toString())

            }

        }

    }

    fun isTrueVisibility(boolean: Boolean, text: LinearLayout, text2: LinearLayout) {
        if (boolean == true) {

            text.visibility = View.GONE
            text2.visibility = View.VISIBLE

        }
    }

}