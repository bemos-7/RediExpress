package com.example.rediexpress.data.delivery

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.serialization.Serializable
import java.net.Inet4Address
import java.util.UUID

class BaseDeliveryManager(
    private val supabaseClient: SupabaseClient
) {

    suspend fun destinationsDetails(
        address: String,
        country: String,
        phone: String,
        others: String,
        track: String
    ) {
        supabaseClient.postgrest["destinations_details"].insert(DestinationsDetails(address = address, country = country, phone = phone, others = others, track = track))
    }

    suspend fun getDestinationsDetails() : DestinationsDetails {

        val retDelivery = supabaseClient.postgrest["destinations_details"].select().decodeSingle<DestinationsDetails>()

        return retDelivery

    }

}
@Serializable
data class DestinationsDetails(
    val id: String? = null,
    val id_order: String? = null,
    val address: String,
    val country: String,
    val phone: String,
    val others: String = "",
    val created_at: String = "",
    val track: String = "",

)