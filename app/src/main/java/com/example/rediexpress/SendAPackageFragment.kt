package com.example.rediexpress

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.databinding.SendAPackageFragmentBinding

class SendAPackageFragment : Fragment() {

    lateinit var binding: SendAPackageFragmentBinding

    lateinit var packageDataViewModel: PackageDataViewModel

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

            phoneSecondInput.addTextChangedListener {

                var phoneSecond = it.toString()

                if (addressInput.text.toString() != "" && stateCountryInput.text.toString() != "" && phoneInput.text.toString() != "" && addressSecondInput.text.toString() != "" && stateCountrySecondInput.text.toString() != "" && phoneSecond != "") {

                    buttonNext.isEnabled = true


                }
                else buttonNext.isEnabled = false

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

                packageDataViewModel.address.value = addressInput.text.toString()
                packageDataViewModel.phone.value = phoneInput.text.toString()
                packageDataViewModel.country.value = phoneInput.text.toString()

                packageDataViewModel.addressSecond.value = addressSecondInput.text.toString()
                packageDataViewModel.phoneSecond.value = phoneSecondInput.text.toString()
                packageDataViewModel.countrySecond.value = stateCountrySecondInput.text.toString()

                packageDataViewModel.packageItem.value = packageItemsPackage.text.toString()
                packageDataViewModel.weightItem.value = weightOfItemPackage.text.toString()
                packageDataViewModel.worthItem.value = worthOfItemsPackage.text.toString()

                parentFragmentManager.beginTransaction().replace(R.id.frame_container, SendAPackageSecondFragment()).commit()

            }

        }

    }

    fun checkPhone() : Boolean {

        return binding.phoneSecondInput.text.toString() != ""

    }

}