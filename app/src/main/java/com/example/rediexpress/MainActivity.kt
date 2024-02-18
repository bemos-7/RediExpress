package com.example.rediexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.databinding.ActivityMainBinding
import com.example.rediexpress.databinding.SendAPackageSecondFragmentBinding
import com.example.rediexpress.presentation.ProfileFragment
import com.example.rediexpress.presentation.screen.account.OtpVerificationFragment
import com.example.rediexpress.presentation.screen.account.forgot_password.ForgotPasswordFragment
import com.example.rediexpress.presentation.screen.account.sign_up.SignUpFragment
import com.example.rediexpress.presentation.screen.account.sign_up.vm.SignUpViewModel
import com.example.rediexpress.presentation.screen.introduction.IntroductionFragment

class MainActivity : AppCompatActivity() {

    lateinit var introductionFragment: IntroductionFragment

    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: PackageDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(PackageDataViewModel::class.java)

        introductionFragment = IntroductionFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, ProgressBarFragment())
            .commit()



        binding.bottomNavItems.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home_bn -> supportFragmentManager.beginTransaction().replace(R.id.frame_container, SendAPackageFragment()).commit()
                R.id.wallet_bn -> null
                R.id.track_bn -> null
                R.id.profile_bn -> supportFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()

            }
            true
        }

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.frame_container, OtpVerificationFragment())
//            .commit()

    }
}