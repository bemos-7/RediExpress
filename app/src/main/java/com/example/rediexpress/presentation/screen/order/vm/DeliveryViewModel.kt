package com.example.rediexpress.presentation.screen.order.vm

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.delivery.BaseDeliveryManager
import com.example.rediexpress.data.delivery.DestinationsDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeliveryViewModel(
    private val deliveryManager: BaseDeliveryManager
) : ViewModel() {

    val state: MutableLiveData<DestinationsDetails> = MutableLiveData()
    val isLoading = MutableLiveData(false)

    val stateError: MutableLiveData<String> = MutableLiveData()

    val scope = CoroutineScope(Dispatchers.IO)

    fun delivery(address: String, country: String, phone: String, other: String, track: String) {

        try {

            scope.launch {

                deliveryManager.destinationsDetails(address, country, phone, other, track)

            }

        } catch (e: Exception) {

            stateError.value = e.message

        }



    }

    fun getDelivery() {

        scope.launch {
            isLoading.postValue(true)
            state.postValue(deliveryManager.getDestinationsDetails())
            isLoading.postValue(false)
        }

    }

    fun deliveryOutput() {

        scope.launch {

            deliveryManager.getDestinationsDetails()

        }

    }
}