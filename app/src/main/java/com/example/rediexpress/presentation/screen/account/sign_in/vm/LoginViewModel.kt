package com.example.rediexpress.presentation.screen.account.sign_in.vm

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.auth.BaseAuthManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authManager: BaseAuthManager
) : ViewModel() {

    val isLoading = MutableLiveData(false)

    val scope = CoroutineScope(Dispatchers.IO)

    fun signIn(email: String, password: String) {

        scope.launch {
                isLoading.postValue(true)
                authManager.signIn(email, password)
                isLoading.postValue(false)
        }

    }

}