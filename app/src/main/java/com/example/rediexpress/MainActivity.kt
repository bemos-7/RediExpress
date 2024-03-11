package com.example.rediexpress

import android.content.Context
import android.hardware.biometrics.BiometricManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.data.passwordHash.MainViewModel
import com.example.rediexpress.data.passwordHash.PasswordRepository
import com.example.rediexpress.databinding.ActivityMainBinding
import com.example.rediexpress.presentation.AddPaymentMethodFragment
import com.example.rediexpress.presentation.ProfileFragment
import com.example.rediexpress.presentation.screen.account.forgot_password.vm.SaveEmailForOTP
import com.example.rediexpress.presentation.screen.account.sign_in.vm.UserEmailSaveViewModel
import com.example.rediexpress.presentation.screen.introduction.IntroductionFragment
import com.example.rediexpress.presentation.screen.order.ProgressBarFragment
import com.example.rediexpress.presentation.screen.order.vm.PackageDataViewModel
import com.example.rediexpress.presentation.screen.order.SendAPackageFragment
import org.osmdroid.config.Configuration
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: PackageDataViewModel

    lateinit var userEmailSaveViewModel: UserEmailSaveViewModel

    lateinit var saveEmailForOTP: SaveEmailForOTP

    lateinit var biometricPrompt: BiometricPrompt
    lateinit var promptInfo: BiometricPrompt.PromptInfo
    lateinit var executor: Executor

    val mainViewModelPass by lazy {

        val passwordRepository = PasswordRepository(this)

        MainViewModel(passwordRepository)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val sharedPreferences = getSharedPreferences("OSM", Context.MODE_PRIVATE)
        Configuration.getInstance().load(this, sharedPreferences)
        setContentView(binding.root)

        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(this@MainActivity, "Authentication error: $errString", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(this@MainActivity, "Authentication failed!", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(this@MainActivity, "Authentication succeeded", Toast.LENGTH_SHORT).show()
            }

        })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Title")
            .setSubtitle("SubTitle")
            .setNegativeButtonText("NegativeButton")
            .build()

//        val biometricManager = androidx.biometric.BiometricManager.from(this)
//        when (biometricManager.canAuthenticate()) {
//            BiometricManager.BIOMETRIC_SUCCESS ->
//                Toast.makeText(this, "Biometric is available", Toast.LENGTH_SHORT).show()
//
//            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
//                Toast.makeText(this, "This device doesn't support biometric", Toast.LENGTH_SHORT).show()
//
//            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
//                Toast.makeText(this, "On this moment biometric not available", Toast.LENGTH_SHORT).show()
//
//            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
//                Toast.makeText(this, "Biometric none enrolled", Toast.LENGTH_SHORT).show()
//        }

        mainViewModel = ViewModelProvider(this).get(PackageDataViewModel::class.java)

        userEmailSaveViewModel = ViewModelProvider(this).get(UserEmailSaveViewModel::class.java)

        saveEmailForOTP = ViewModelProvider(this).get(SaveEmailForOTP::class.java)

        mainViewModelPass.get()

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