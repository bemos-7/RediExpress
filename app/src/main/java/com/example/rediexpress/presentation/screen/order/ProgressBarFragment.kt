package com.example.rediexpress.presentation.screen.order

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.App
import com.example.rediexpress.R
import com.example.rediexpress.databinding.ProgressBarFragmentBinding
import com.example.rediexpress.presentation.screen.order.vm.DeliveryViewModel

class ProgressBarFragment : Fragment() {

    lateinit var binding: ProgressBarFragmentBinding
    lateinit var timer: CountDownTimer

    val deliveryViewModel = DeliveryViewModel(App.instance.baseDeliveryManager)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProgressBarFragmentBinding.inflate(inflater)
        deliveryViewModel.getDelivery()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var count = 0

        timer = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                count = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                binding.progressBar.setBackgroundResource(R.drawable.good_tick)
                binding.progressBar.setProgress(0, true)
            }

        }.start()



        deliveryViewModel.state.observe(viewLifecycleOwner) {

            binding.trackText.text = it.address

        }



    }

}