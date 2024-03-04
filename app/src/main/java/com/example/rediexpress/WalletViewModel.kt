package com.example.rediexpress

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.auth.BaseAuthManager
import com.example.rediexpress.data.auth.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WalletViewModel(
    private val authManager: BaseAuthManager
) : ViewModel() {

    val isLoading = MutableLiveData(false)

    val stateError: MutableLiveData<String> = MutableLiveData()

    val state: MutableLiveData<Profile> = MutableLiveData()

    val scope = CoroutineScope(Dispatchers.IO)

    fun getProfile(email: String) {

        try {

            scope.launch {
                isLoading.postValue(true)
                state.postValue(authManager.getProfile(email))
                isLoading.postValue(false)
            }

        } catch (e: Exception) {
            stateError.value = e.message
        }



    }

}