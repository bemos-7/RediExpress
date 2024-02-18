package com.example.rediexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.databinding.ActivityMainBinding
import com.example.rediexpress.presentation.ProfileFragment
import com.example.rediexpress.presentation.screen.introduction.IntroductionFragment
import com.example.rediexpress.presentation.screen.order.ProgressBarFragment
import com.example.rediexpress.presentation.screen.order.vm.PackageDataViewModel
import com.example.rediexpress.presentation.screen.order.SendAPackageFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: PackageDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(PackageDataViewModel::class.java)

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

    }
}