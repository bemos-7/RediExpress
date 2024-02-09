package com.example.rediexpress.data.auth

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.serialization.Serializable

class BaseAuthManager(
    private val supabaseClient: SupabaseClient
){

    suspend fun sendOtp(
        email: String
    ){
        supabaseClient.auth.resetPasswordForEmail(email)
    }

    suspend fun signUp(
        name: String,
        phone: String,
        email: String,
        password: String
    ) {
        supabaseClient.postgrest["profiles"].insert(Profile(fullname = name, phone = phone))
        supabaseClient.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }

    }

    suspend fun signIn(
        email: String,
        password: String
    ) {
        supabaseClient.auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }
}

@Serializable
data class Profile(
    val id: Int? = null,
    val createdAt: String = "",
    val fullname: String,
    val balance: Int = 0,
    val rider: Boolean = false,
    val phone: String,
)