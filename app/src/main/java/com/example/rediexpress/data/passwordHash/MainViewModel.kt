package com.example.rediexpress.data.passwordHash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val passwordRepository: PasswordRepository
) : ViewModel() {

    val state = MutableLiveData<String>()

    fun get() {
        state.value = passwordRepository.get()
    }

    fun set(passwordText: String) {
        passwordRepository.save(passwordText)
        state.value = passwordText
    }

}