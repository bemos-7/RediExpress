package com.example.rediexpress

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.databinding.ActivityMainBinding
import com.example.rediexpress.presentation.AddPaymentMethodFragment
import com.example.rediexpress.presentation.ProfileFragment
import com.example.rediexpress.presentation.screen.account.sign_in.vm.UserEmailSaveViewModel
import com.example.rediexpress.presentation.screen.introduction.IntroductionFragment
import com.example.rediexpress.presentation.screen.order.ProgressBarFragment
import com.example.rediexpress.presentation.screen.order.vm.PackageDataViewModel
import com.example.rediexpress.presentation.screen.order.SendAPackageFragment
import org.osmdroid.config.Configuration

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: PackageDataViewModel

    lateinit var userEmailSaveViewModel: UserEmailSaveViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val sharedPreferences = getSharedPreferences("OSM", Context.MODE_PRIVATE)
        Configuration.getInstance().load(this, sharedPreferences)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(PackageDataViewModel::class.java)

        userEmailSaveViewModel = ViewModelProvider(this).get(UserEmailSaveViewModel::class.java)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, IntroductionFragment())
            .commit()

        binding.bottomNavItems.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home_bn -> supportFragmentManager.beginTransaction().replace(R.id.frame_container, HomeFragment()).commit()
                R.id.wallet_bn -> supportFragmentManager.beginTransaction().replace(R.id.frame_container, WalletFragment()).commit()
                R.id.track_bn -> supportFragmentManager.beginTransaction().replace(R.id.frame_container, TrackingPackageFragment()).commit()
                R.id.profile_bn -> supportFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()

            }
            true
        }

    }
}