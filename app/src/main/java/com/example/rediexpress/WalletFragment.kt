package com.example.rediexpress

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import com.example.rediexpress.databinding.WalletFragmentBinding
import com.example.rediexpress.presentation.screen.account.sign_in.vm.UserEmailSaveViewModel

class WalletFragment : Fragment() {

    lateinit var binding: WalletFragmentBinding

    val walletViewModel = WalletViewModel(App.instance.baseAuthManager)

    lateinit var userEmailSaveViewModel: UserEmailSaveViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WalletFragmentBinding.inflate(inflater)

        var email: String

        val mainActivity = activity as MainActivity

        userEmailSaveViewModel = mainActivity.userEmailSaveViewModel

        userEmailSaveViewModel.email.observe(viewLifecycleOwner) {

            email = it

            walletViewModel.getProfile(email)

        }

        walletViewModel.isLoading.observe(viewLifecycleOwner) {

            if (it) {
                binding.progressNet.visibility = View.VISIBLE
            } else  {
                binding.progressNet.visibility = View.GONE
            }

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        walletViewModel.state.observe(viewLifecycleOwner) {

            binding.balanceText.text = it.balance.toString() + "$"
            binding.userName.text = it.fullname
            binding.avatar.load("https://static.scientificamerican.com/sciam/cache/file/32665E6F-8D90-4567-9769D59E11DB7F26_source.jpg?w=600")

        }

        walletViewModel.stateError.observe(viewLifecycleOwner) {

            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

        }

    }

}