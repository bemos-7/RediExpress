package com.example.rediexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rediexpress.account.SignUpFragment
import com.example.rediexpress.databinding.ActivityMainBinding
import com.example.rediexpress.introduction.IntroductionFragment

class MainActivity : AppCompatActivity() {

    lateinit var introductionFragment: IntroductionFragment

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        introductionFragment = IntroductionFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, IntroductionFragment())
            .commit()



    }
}