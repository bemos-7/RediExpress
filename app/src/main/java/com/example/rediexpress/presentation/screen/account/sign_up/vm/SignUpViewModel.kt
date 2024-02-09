package com.example.rediexpress.presentation.screen.account.sign_up.vm

import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.auth.BaseAuthManager
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authManager: BaseAuthManager
) : ViewModel() {

    var scope = CoroutineScope(Dispatchers.IO)
    fun signUp(email: String, password: String, phone: String, name: String) {

        scope.launch {

            authManager.signUp(name, phone, email, password)

        }
    }
}