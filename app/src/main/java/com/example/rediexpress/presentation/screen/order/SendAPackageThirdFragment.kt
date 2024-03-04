package com.example.rediexpress.presentation.screen.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.rediexpress.App
import com.example.rediexpress.MainActivity
import com.example.rediexpress.R
import com.example.rediexpress.SuccessfulProgressFragment
import com.example.rediexpress.TrackingPackageFragment
import com.example.rediexpress.databinding.SendAPackageSecondFragmentBinding
import com.example.rediexpress.databinding.SendAPackageThirdFragmentBinding
import com.example.rediexpress.isConnectedToInternet
import com.example.rediexpress.presentation.screen.order.vm.DeliveryViewModel
import com.example.rediexpress.presentation.screen.order.vm.PackageDataViewModel

class SendAPackageThirdFragment : Fragment() {

    lateinit var binding: SendAPackageThirdFragmentBinding

    val deliveryViewModel = DeliveryViewModel(App.instance.baseDeliveryManager)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        deliveryViewModel.getDelivery()
        binding = SendAPackageThirdFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mainViewModel = activity as MainActivity

        with(binding) {

            deliveryViewModel.state.observe(viewLifecycleOwner) {
                if (isConnectedToInternet(requireContext())) {

                    addressSecond.text = it.address

                } else {
                    Toast.makeText(requireContext(), "Отсутствует интернет соединение", Toast.LENGTH_SHORT).show()
                }
            }

            deliveryViewModel.state.observe(viewLifecycleOwner) {
                if (isConnectedToInternet(requireContext())) {

                    phoneSecond.text = it.phone

                } else {
                    Toast.makeText(requireContext(), "Отсутствует интернет соединение", Toast.LENGTH_SHORT).show()
                }
            }

            deliveryViewModel.state.observe(viewLifecycleOwner) {

                if (isConnectedToInternet(requireContext())) {

                    trackNumber.text = it.track

                } else {
                    Toast.makeText(requireContext(), "Отсутствует интернет соединение", Toast.LENGTH_SHORT).show()
                }
            }

            deliveryViewModel.isLoading.observe(viewLifecycleOwner) {

                if (isConnectedToInternet(requireContext())) {

                    if (it) {
                        progressNet.visibility = View.VISIBLE
                    } else {
                        progressNet.visibility = View.GONE
                    }

                } else {
                    Toast.makeText(requireContext(), "Отсутствует интернет соединение", Toast.LENGTH_SHORT).show()
                }
            }

            deliveryViewModel.stateError.observe(viewLifecycleOwner) {

                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

            }

            var deliveryCharges = 2500
            var instantDelivery = 300
            var tax = (((deliveryCharges + instantDelivery) * 5) / 100)

            binding.deliveryCharges.text = deliveryCharges.toString()
            binding.instantDelivery.text = instantDelivery.toString()
            binding.tax.text = tax.toString()

            binding.backButton.setOnClickListener {

                parentFragmentManager.popBackStack()

            }

            binding.successfulBtn.setOnClickListener {

                parentFragmentManager.beginTransaction().replace(R.id.frame_container, SuccessfulProgressFragment()).commit()

            }

        }

    }


}