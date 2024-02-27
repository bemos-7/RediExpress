package com.example.rediexpress.presentation.screen.order

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.App
import com.example.rediexpress.MainActivity
import com.example.rediexpress.R
import com.example.rediexpress.TrackingPackageFragment
import com.example.rediexpress.databinding.ProgressBarFragmentBinding
import com.example.rediexpress.presentation.ProfileFragment
import com.example.rediexpress.presentation.screen.order.vm.DeliveryViewModel
import com.example.rediexpress.presentation.screen.order.vm.PackageDataViewModel

class ProgressBarFragment : Fragment() {

    lateinit var binding: ProgressBarFragmentBinding
    lateinit var timer: CountDownTimer

    lateinit var packageDataViewModel: PackageDataViewModel

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

        val mainViewModel = activity as MainActivity

        packageDataViewModel = mainViewModel.mainViewModel


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

        packageDataViewModel.trackNumber.observe(viewLifecycleOwner) {

            binding.trackNumber.text = it

        }

        binding.trackMyItem.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, TrackingPackageFragment()).commit()

        }

        binding.goBackToHomepage.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()

        }

    }

}