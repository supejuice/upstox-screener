package com.example.screener.feature.portfolio.data

import retrofit2.http.GET

interface PortfolioDataSource {
    @GET("/")
    suspend fun getHoldings(): UserHoldingsDto?

    fun putHoldings(holdings: UserHoldingsDto)
}

class PortfolioCache : PortfolioDataSource {
    private var userHoldings: UserHoldingsDto? = null

    override suspend fun getHoldings(): UserHoldingsDto? {
        return userHoldings
    }

    override fun putHoldings(holdings: UserHoldingsDto) {
        userHoldings = holdings
    }

}