package com.example.rediexpress

import android.app.Application
import com.example.rediexpress.data.auth.BaseAuthManager
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
            "https://swhjwngmcsnpmyctuvpe.supabase.co/",
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InN3aGp3bmdtY3NucG15Y3R1dnBlIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODg0OTMyMDUsImV4cCI6MjAwNDA2OTIwNX0.nIr-jF95sahGuahxr3eUWkSszEi04atMsISbeytwOB8") {
            install(Postgrest)
            install(Auth)
        }
    }
    val baseAuthManager by lazy {
        BaseAuthManager(supabaseClient)
    }
}