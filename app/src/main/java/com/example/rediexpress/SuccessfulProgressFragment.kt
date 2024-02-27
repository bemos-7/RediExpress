package com.example.rediexpress

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.databinding.SuccessfulProgressFragmentBinding

class SuccessfulProgressFragment : Fragment() {

    lateinit var binding: SuccessfulProgressFragmentBinding
    lateinit var timer: CountDownTimer
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SuccessfulProgressFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        timer = object : CountDownTimer(3000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                var count = millisUntilFinished
            }

            override fun onFinish() {
                binding.progressBar.visibility = View.GONE
                binding.greenDone.visibility = View.VISIBLE
                binding.textSucc.visibility = View.VISIBLE
            }

        }.start()   
    }

}