package com.example.rediexpress.data.delivery

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.serialization.Serializable
import java.net.Inet4Address
import java.util.UUID

class BaseOrderDetailes(
    private val supabaseClient: SupabaseClient
) {

    suspend fun orders(
        address: String,
        country: String,
        phone: String,
        others: String,
        weight_items: String,
        worth_items: String,
        items: String
    ) {
        supabaseClient.postgrest["orders"].insert(Orders(address = address, country = country, phone = phone, others = others, weight_items = weight_items, worth_items = worth_items, items = items))
    }

    suspend fun getOrders() : Orders {

        val retOrders = supabaseClient.postgrest["orders"].select().decodeSingle<Orders>()

        return retOrders

    }

    suspend fun deleteOrderDetails(phone: String) {

        supabaseClient.postgrest["orders"].delete {

            filter {
                eq("phone", phone)
            }

        }

    }

}
@Serializable
data class Orders(
    val id: String? = null,
    val id_user: String? = null,
    val address: String,
    val country: String,
    val phone: String,
    val others: String = "",
    val items: String,
    val weight_items: String,
    val worth_items: String,
    val created_at: String = "",
    val payed: String = "",
    val status: String = "",
    val succesed: String = "",
    val rate: String = "",
    val feedback: String = "",

)