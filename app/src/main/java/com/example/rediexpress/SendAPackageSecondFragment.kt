package com.example.rediexpress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.databinding.SendAPackageSecondFragmentBinding

class SendAPackageSecondFragment : Fragment() {

    lateinit var binding: SendAPackageSecondFragmentBinding

    lateinit var packageDataViewModel: PackageDataViewModel
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

            var deliveryCharges = 2500
            var instantDelivery = 300
            var tax = ((deliveryCharges + instantDelivery) - 0.05) - (deliveryCharges + instantDelivery)



        }



        binding.editPackageButton.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, SendAPackageFragment()).commit()

        }

    }


}