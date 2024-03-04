package com.example.rediexpress.presentation.screen.order.vm

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rediexpress.data.delivery.BaseDeliveryManager
import com.example.rediexpress.data.delivery.BaseOrderDetailes
import com.example.rediexpress.data.delivery.DestinationsDetails
import com.example.rediexpress.data.delivery.Orders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderViewModel(
    private val orderManager: BaseOrderDetailes
) : ViewModel() {

    val state: MutableLiveData<Orders> = MutableLiveData()

    val scope = CoroutineScope(Dispatchers.IO)

    val stateError = MutableLiveData<String>()

    fun order(address: String, country: String, phone: String, other: String, weightItems: String, worthtItems: String, items: String) {

        try {

            scope.launch {

                orderManager.orders(address, country, phone, other, weightItems, worthtItems, items)

            }

        } catch (e: Exception) {
            stateError.value = e.message
        }
    }

    fun getOrder() {

        try {

            scope.launch {

                state.postValue(orderManager.getOrders())

            }

        } catch (e: Exception) {
            stateError.value = e.message
        }

    }

    fun deliveryOutput() {

        scope.launch {

            orderManager.getOrders()

        }

    }
}