package com.example.rediexpress.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.R
import com.example.rediexpress.databinding.AddPaymentMethodFragmentBinding
import com.example.rediexpress.databinding.NotificationFragmentBinding

class NotificationFragment : Fragment() {

    lateinit var binding: NotificationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NotificationFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.backButton.setOnClickListener{

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()

        }

    }

}