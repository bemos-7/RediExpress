package com.example.rediexpress.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.rediexpress.R
import com.example.rediexpress.databinding.AddPaymentMethodFragmentBinding

class AddPaymentMethodFragment : Fragment() {

    lateinit var binding: AddPaymentMethodFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddPaymentMethodFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {

            backButton.setOnClickListener{

                parentFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()

            }

            payWithWallet.setOnClickListener {

                radioButtonFirst.setBackgroundResource(R.drawable.radio_selected)
                radioButtonSecond.setBackgroundResource(R.drawable.radio_unselected)

                cardView.isVisible = false
                cardViewSecond.isVisible = false


            }

            creditDebitCard.setOnClickListener {

                radioButtonFirst.setBackgroundResource(R.drawable.radio_unselected)
                radioButtonSecond.setBackgroundResource(R.drawable.radio_selected)

                cardView.isVisible = true
                cardViewSecond.isVisible = true

                cardView.setOnClickListener {

                    cardRadio.setBackgroundResource(R.drawable.radio_selected)
                    cardRadioSecond.setBackgroundResource(R.drawable.radio_unselected)

                }

                cardViewSecond.setOnClickListener {

                    cardRadioSecond.setBackgroundResource(R.drawable.radio_selected)
                    cardRadio.setBackgroundResource(R.drawable.radio_unselected)

                }

            }

        }




    }
}