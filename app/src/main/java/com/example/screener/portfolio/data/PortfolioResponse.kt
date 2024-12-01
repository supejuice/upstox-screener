package com.example.screener.portfolio.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PortfolioResponse(
    @SerialName("data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("userHolding")
        val userHolding: List<UserHolding>
    ) {
        @Serializable
        data class UserHolding(
            @SerialName("avgPrice")
            val avgPrice: Double,
            @SerialName("close")
            val close: Double,
            @SerialName("ltp")
            val ltp: Double,
            @SerialName("quantity")
            val quantity: Int,
            @SerialName("symbol")
            val symbol: String
        )
    }
}