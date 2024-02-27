package com.example.rediexpress.presentation.screen.account.sign_in.vm

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.auth.BaseAuthManager
import com.example.rediexpress.data.auth.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserEmailSaveViewModel() : ViewModel() {

    val email: MutableLiveData<String> = MutableLiveData()

}