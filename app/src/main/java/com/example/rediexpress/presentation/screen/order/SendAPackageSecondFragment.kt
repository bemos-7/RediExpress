package com.example.rediexpress.presentation.screen.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.App
import com.example.rediexpress.MainActivity
import com.example.rediexpress.R
import com.example.rediexpress.databinding.SendAPackageSecondFragmentBinding
import com.example.rediexpress.presentation.screen.order.vm.DeliveryViewModel
import com.example.rediexpress.presentation.screen.order.vm.PackageDataViewModel
import java.util.UUID

class SendAPackageSecondFragment : Fragment() {

    lateinit var binding: SendAPackageSecondFragmentBinding

    lateinit var packageDataViewModel: PackageDataViewModel

    val deliveryViewModel = DeliveryViewModel(App.instance.baseDeliveryManager)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SendAPackageSecondFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mainViewModel = activity as MainActivity

        packageDataViewModel = mainViewModel.mainViewModel

        with(binding) {

            packageDataViewModel.address.observe(viewLifecycleOwner) {

                addressOutput.text = it.toString()

            }

            packageDataViewModel.phone.observe(viewLifecycleOwner) {

                phoneOutput.text = it.toString()

            }

            packageDataViewModel.packageItem.observe(viewLifecycleOwner) {

                packageItemOutput.text = it.toString()

            }

            packageDataViewModel.addressSecond.observe(viewLifecycleOwner) {

                addressSecond.text = it.toString()

            }

            packageDataViewModel.phoneSecond.observe(viewLifecycleOwner) {

                phoneSecond.text = it.toString()

            }

            packageDataViewModel.weightItem.observe(viewLifecycleOwner) {

                weightOutput.text = it.toString()

            }

            packageDataViewModel.worthItem.observe(viewLifecycleOwner) {

                worthOutput.text = it.toString()

            }

            packageDataViewModel.trackNumber.observe(viewLifecycleOwner) {

                trackText.text = it.toString()

            }

            var deliveryCharges = 2500
            var instantDelivery = 300
            var tax = (((deliveryCharges + instantDelivery) * 5) / 100)

            binding.deliveryCharges.text = deliveryCharges.toString()
            binding.instantDelivery.text = instantDelivery.toString()
            binding.tax.text = tax.toString()

        }

        binding.editPackageButton.setOnClickListener {

            parentFragmentManager.beginTransaction().remove(this).commit()

        }

        binding.makePayment.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, ProgressBarFragment()).commit()

        }

    }


}