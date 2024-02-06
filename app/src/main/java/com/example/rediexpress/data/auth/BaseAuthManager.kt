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
        supabaseClient.auth.signUpWith(Email){
            this.email = email
            this.password = "SDFF"
        }
    }

    suspend fun signUp(
        email: String,
        password: String
    ) {
        supabaseClient.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }

    }

    suspend fun resetPassword(
        phone: String,
        name: String
    ){
        supabaseClient.auth.modifyUser {

        }
    }

}

@Serializable
data class Profile(
    val phone: String,
    val name: String
)