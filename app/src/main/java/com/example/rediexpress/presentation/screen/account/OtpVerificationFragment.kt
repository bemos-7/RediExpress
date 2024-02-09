package com.example.rediexpress.presentation.screen.account

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.rediexpress.R
import com.example.rediexpress.databinding.OtpVereficationFragmentBinding

class OtpVerificationFragment : Fragment() {

    lateinit var binding: OtpVereficationFragmentBinding
    lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OtpVereficationFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {

            var count = 0

            notEmptyBlue(oneDigit, twoDigit)
            notEmptyBlue(twoDigit, threeDigit)
            notEmptyBlue(threeDigit, fourDigit)
            notEmptyBlue(fourDigit, fiveDigit)
            notEmptyBlue(fiveDigit, sixDigit)
            notEmptyBlue(sixDigit, sixDigit)

            sixDigit.addTextChangedListener {

                var six = it.toString()

                if (six.length != 0) {
                    sendButton.isEnabled = true
                }
                else sendButton.isEnabled = false

            }

            timer = object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timerText.text = "If you didn’t receive code, ${(millisUntilFinished / 1000).toString()}"
                    timerText.isEnabled = false
                }

                override fun onFinish() {
                    timerText.text = "If you didn’t receive code, resend"
                    timerText.isEnabled = true
                }


            }.start()

        }
    }
    fun notEmptyBlue(digit: EditText, degitSecond: EditText) {

        digit.addTextChangedListener {

            var number = it.toString()

            if (number.length != 0) {
                digit.setBackgroundResource(R.drawable.input_text_correct_blue)
                degitSecond.requestFocus()
            }
            else digit.setBackgroundResource(R.drawable.input_text_correct)

        }

    }

}