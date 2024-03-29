package com.example.rediexpress.presentation

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import coil.load
import com.example.rediexpress.App
import com.example.rediexpress.MainActivity
import com.example.rediexpress.R
import com.example.rediexpress.WalletViewModel
import com.example.rediexpress.databinding.AddPaymentMethodFragmentBinding
import com.example.rediexpress.databinding.ProfileFragmentBinding
import com.example.rediexpress.isConnectedToInternet
import com.example.rediexpress.presentation.screen.account.sign_in.vm.UserEmailSaveViewModel

class ProfileFragment : Fragment() {

    lateinit var binding: ProfileFragmentBinding

    lateinit var userEmailSaveViewModel: UserEmailSaveViewModel

    val walletViewModel = WalletViewModel(App.instance.baseAuthManager)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileFragmentBinding.inflate(inflater)

        var email: String

        val mainActivity = activity as MainActivity

        userEmailSaveViewModel = mainActivity.userEmailSaveViewModel

        userEmailSaveViewModel.email.observe(viewLifecycleOwner) {

            email = it

            walletViewModel.getProfile(email)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.cardBlankButton.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, AddPaymentMethodFragment()).commit()
        }

        binding.notificationButton.setOnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.frame_container, NotificationFragment()).commit()

        }

        walletViewModel.state.observe(viewLifecycleOwner) {

            if (walletViewModel.isBalanceHide.value!!) {

                binding.balanceProfileText.text = it.balance.toString() + "$"

            } else binding.balanceProfileText.text = "*****$"


            binding.profileName.text = it.fullname

            binding.avatar.load(it.avatar)

        }

        walletViewModel.isLoading.observe(viewLifecycleOwner) {

            if (it) {

                binding.progressLoad.visibility = View.VISIBLE

            } else  {

                binding.progressLoad.visibility = View.GONE

            }


        }

        binding.eyeButton.setOnClickListener {

            walletViewModel.changeBalanceHide()

        }

        walletViewModel.isBalanceHide.observe(viewLifecycleOwner) {

            if (it) {
                 binding.balanceProfileText.text = walletViewModel.state.value?.balance.toString() + "$"
            } else {
                binding.balanceProfileText.text = "*****$"
            }

        }



        walletViewModel.stateError.observe(viewLifecycleOwner) {

            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

        }

        binding.swithMode.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked == true) {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

        }
    }

}