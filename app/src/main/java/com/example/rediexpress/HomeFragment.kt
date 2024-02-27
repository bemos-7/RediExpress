package com.example.rediexpress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.databinding.HomeFragmentBinding
import com.example.rediexpress.databinding.SendAPackageThirdFragmentBinding
import com.example.rediexpress.presentation.screen.order.SendAPackageFragment

class HomeFragment : Fragment() {

    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.sendAPackage.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, SendAPackageFragment()).commit()

        }

    }

}