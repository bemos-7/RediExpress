package com.example.rediexpress.presentation.screen.order.vm

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.delivery.BaseDeliveryManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeliveryViewModel(
    private val deliveryManager: BaseDeliveryManager
) : ViewModel() {

    val scope = CoroutineScope(Dispatchers.IO)

    fun delivery(address: String, country: String, phone: String, other: String) {

        scope.launch {

            deliveryManager.destinationsDetails(address, country, phone, other)

        }

    }

    fun deliveryOutput() {

        scope.launch {

            deliveryManager.getDestinationsDetails()

        }

    }
}