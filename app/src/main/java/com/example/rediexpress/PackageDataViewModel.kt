package com.example.rediexpress

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PackageDataViewModel : ViewModel() {

    val address: MutableLiveData<String> = MutableLiveData()

    val phone: MutableLiveData<String> = MutableLiveData()

    val country: MutableLiveData<String> = MutableLiveData()


    val addressSecond: MutableLiveData<String> = MutableLiveData()

    val phoneSecond: MutableLiveData<String> = MutableLiveData()

    val countrySecond: MutableLiveData<String> = MutableLiveData()


    val packageItem: MutableLiveData<String> = MutableLiveData()

    val weightItem: MutableLiveData<String> = MutableLiveData()

    val worthItem: MutableLiveData<String> = MutableLiveData()
}