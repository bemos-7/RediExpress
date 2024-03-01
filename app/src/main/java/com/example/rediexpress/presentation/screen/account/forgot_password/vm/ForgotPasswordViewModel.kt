package com.example.rediexpress.presentation.screen.account.forgot_password.vm

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.auth.BaseAuthManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(
    private val authManager: BaseAuthManager
): ViewModel() {

    val stateError: MutableLiveData<String> = MutableLiveData()

    var scope = CoroutineScope(Dispatchers.IO)

    fun forgotPass(
        email: String
    ) {

        try {

            scope.launch {

                authManager.sendOtp(email)

            }

        } catch (e: Exception) {
            stateError.value = e.message
        }

    }

}