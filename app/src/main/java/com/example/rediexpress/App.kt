package com.example.rediexpress

import android.app.Application
import com.example.rediexpress.data.auth.BaseAuthManager
import com.example.rediexpress.data.delivery.BaseDeliveryManager
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this


    }
    private val supabaseClient by lazy {
        createSupabaseClient(
            "https://jyigbjgcdvmxtjwixcea.supabase.co",
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imp5aWdiamdjZHZteHRqd2l4Y2VhIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDgyNTU0MjksImV4cCI6MjAyMzgzMTQyOX0.oUtvji7CjDbYw_rk4OIKJO7Yz9fhgz8d1Rw9-_BnVEs") {
            install(Postgrest)
            install(Auth)
        }
    }
    val baseAuthManager by lazy {
        BaseAuthManager(supabaseClient)
    }
    val baseDeliveryManager by lazy {
        BaseDeliveryManager(supabaseClient)
    }
}