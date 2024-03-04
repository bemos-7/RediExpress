package com.example.rediexpress.data.auth

import android.util.Log
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.result.PostgrestResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class BaseAuthManager(
    private val supabaseClient: SupabaseClient
){

    suspend fun sendOtp(
        email: String
    ){
        Log.d("first", email)
        supabaseClient.auth.signInWith(OTP) {
            this.email = email
        }
    }

    suspend fun confirmOTP(
        email: String,
        token: String
    ) {
        supabaseClient.auth.verifyEmailOtp(OtpType.Email.EMAIL, email = email, token = token)
    }

    suspend fun signUp(
        name: String,
        phone: String,
        email: String,
        password: String
    ) {
        supabaseClient.postgrest["profiles"].insert(Profile(fullname = name, phone = phone, email = email))
        supabaseClient.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }

    }

    suspend fun signIn(
        email: String,
        password: String
    ) {
        Log.d("second", email)
        Log.d("third", password)
        supabaseClient.auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

    suspend fun getProfile(email: String): Profile {

        var profile = supabaseClient.postgrest["profiles"].select() {

            filter {
                eq("email", email)
            }

        }.decodeSingle<Profile>()

        return profile
    }
}

@Serializable
data class Profile(
    val id: Int? = null,
    @SerialName("created_at")
    val createdAt: String = "",
    val avatar: String = "",
    val email: String,
    val fullname: String,
    val balance: Int = 0,
    val rider: Boolean = false,
    val phone: String,
)