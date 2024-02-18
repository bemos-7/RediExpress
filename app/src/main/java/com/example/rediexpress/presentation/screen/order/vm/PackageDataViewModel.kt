package com.example.rediexpress.presentation.screen.order.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.delivery.BaseDeliveryManager
import com.example.rediexpress.data.delivery.DestinationsDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PackageDataViewModel() : ViewModel() {

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