package com.example.rediexpress.presentation.screen.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rediexpress.databinding.EmptyFragmentBinding

class EmptyFragment : Fragment() {

    lateinit var binding: EmptyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EmptyFragmentBinding.inflate(inflater)
        return binding.root
    }

}