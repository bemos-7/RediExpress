package com.example.rediexpress.presentation.screen.order

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.rediexpress.App
import com.example.rediexpress.MainActivity
import com.example.rediexpress.R
import com.example.rediexpress.databinding.SendAPackageFragmentBinding
import com.example.rediexpress.isConnectedToInternet
import com.example.rediexpress.presentation.screen.order.vm.DeliveryViewModel
import com.example.rediexpress.presentation.screen.order.vm.OrderViewModel
import com.example.rediexpress.presentation.screen.order.vm.PackageDataViewModel
import java.util.UUID
import kotlin.random.Random

class SendAPackageFragment : Fragment() {

    lateinit var binding: SendAPackageFragmentBinding

    lateinit var packageDataViewModel: PackageDataViewModel

    val deliveryViewModel = DeliveryViewModel(App.instance.baseDeliveryManager)
    val orderViewModel = OrderViewModel(App.instance.baseOrderDetailes)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SendAPackageFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {

            worthOfItemsPackage.addTextChangedListener {

                var worthOfItems = it.toString()

                if (addressInput.text.toString() != "" && worthOfItemsPackage.text.toString() != "" && stateCountryInput.text.toString() != "" && phoneInput.text.toString() != "" && addressSecondInput.text.toString() != "" && stateCountrySecondInput.text.toString() != "" && packageItemsPackage.text.toString() != "" && weightOfItemPackage.text.toString() != "" && worthOfItems != "") {

                    buttonNext.isEnabled = true

                } else buttonNext.isEnabled = false

            }

            instantButton.setOnClickListener {

                sheduledButton.setBackgroundResource(R.color.white)
                dataDeliveryLong.setColorFilter(Color.parseColor("#D7D7D7"))
                dataDeliveryLongText.setTextColor(Color.parseColor("#D7D7D7"))

                instantButton.setBackgroundResource(R.drawable.button_next)
                dataDeliveryQuick.setColorFilter(Color.parseColor("#FFFFFFFF"))
                dataDeliveryQuickText.setTextColor(Color.parseColor("#FFFFFFFF"))

            }

            sheduledButton.setOnClickListener {

                sheduledButton.setBackgroundResource(R.drawable.button_next)
                dataDeliveryLong.setColorFilter(Color.parseColor("#FFFFFFFF"))
                dataDeliveryLongText.setTextColor(Color.parseColor("#FFFFFFFF"))

                instantButton.setBackgroundResource(R.color.white)
                dataDeliveryQuick.setColorFilter(Color.parseColor("#D7D7D7"))
                dataDeliveryQuickText.setTextColor(Color.parseColor("#D7D7D7"))

            }

            val mainViewModel = activity as MainActivity

            packageDataViewModel = mainViewModel.mainViewModel

            buttonNext.setOnClickListener {

                if (isConnectedToInternet(requireContext())) {

                    packageDataViewModel.address.value = addressInput.text.toString()
                    packageDataViewModel.phone.value = phoneInput.text.toString()
                    packageDataViewModel.country.value = phoneInput.text.toString()

                    packageDataViewModel.addressSecond.value = addressSecondInput.text.toString()
                    packageDataViewModel.phoneSecond.value = phoneSecondInput.text.toString()
                    packageDataViewModel.countrySecond.value = stateCountrySecondInput.text.toString()

                    packageDataViewModel.packageItem.value = packageItemsPackage.text.toString()
                    packageDataViewModel.weightItem.value = weightOfItemPackage.text.toString()
                    packageDataViewModel.worthItem.value = worthOfItemsPackage.text.toString()

                    val track2 = UUID.randomUUID().toString()

                    packageDataViewModel.trackNumber.value = track2

                    deliveryViewModel.delivery(
                        addressSecondInput.text.toString(),
                        stateCountrySecondInput.text.toString(),
                        phoneSecondInput.text.toString(),
                        otherSecond.text.toString(),
                        track2
                    )

                    orderViewModel.order(
                        addressInput.text.toString(),
                        stateCountryInput.text.toString(),
                        phoneInput.text.toString(),
                        other.text.toString(),
                        weightOfItemPackage.text.toString(),
                        worthOfItemsPackage.text.toString(),
                        packageItemsPackage.text.toString()
                    )

                    parentFragmentManager.beginTransaction()
                        .add(R.id.frame_container, SendAPackageSecondFragment(), "secondSend")
                        .addToBackStack(null)
                        .commit()

                } else {
                    Toast.makeText(requireContext(), "Отсутствует интеренет соединение", Toast.LENGTH_SHORT).show()
                }

            }

            deliveryViewModel.stateError.observe(viewLifecycleOwner) {

                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

            }

            orderViewModel.stateError.observe(viewLifecycleOwner) {

                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

            }

        }

    }

    fun checkPhone(): Boolean {

        return binding.phoneSecondInput.text.toString() != ""

    }

}
