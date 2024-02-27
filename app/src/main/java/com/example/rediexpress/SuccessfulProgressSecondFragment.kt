package com.example.rediexpress

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.databinding.SuccessfulProgressFragmentBinding
import com.example.rediexpress.databinding.SuccessfulProgressSecondFragmentBinding
import com.example.rediexpress.presentation.ProfileFragment

class SuccessfulProgressSecondFragment : Fragment() {

    lateinit var binding: SuccessfulProgressSecondFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SuccessfulProgressSecondFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.doneButton.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()

        }

    }

}