package com.example.rediexpress

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import io.ktor.utils.io.core.toByteArray
import java.security.MessageDigest

fun hash(text: String): String {
    val bytes = text.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("") { str, it -> str + "%02x".format(it) }
}