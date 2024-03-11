package com.example.rediexpress.data.passwordHash

import android.content.Context
import androidx.core.content.edit

class PasswordRepository(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("STR", Context.MODE_PRIVATE)

    fun get() : String {
        return sharedPreferences.getString("passKey", "none")?: "null"
    }

    fun save(password: String) {
        sharedPreferences.edit{
            putString("passKey", password)
        }
    }

}