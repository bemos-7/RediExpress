package com.example.rediexpress.presentation.screen.account

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.R
import com.example.rediexpress.data.auth.BaseAuthManager
import com.example.rediexpress.databinding.OtpVereficationFragmentBinding
import io.github.jan.supabase.gotrue.OtpType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OtpVerificationViewModel(
    private val authManager: BaseAuthManager
) : ViewModel() {

    val stateError = MutableLiveData<String>()

    val showNextFragment = MutableLiveData<Boolean>(false)

    val scope = CoroutineScope(Dispatchers.IO)

    fun confirmOtp(email: String, token: String) {

        scope.launch {

            try {
                Log.d("errorTag", "start")
                authManager.confirmOTP(email, token)
                showNextFragment.postValue(true)
                Log.d("errorTag", "success")
            } catch (e: Exception) {
                Log.d("errorTag", "stateError")
                stateError.postValue(e.message)
            }

        }
    }

}