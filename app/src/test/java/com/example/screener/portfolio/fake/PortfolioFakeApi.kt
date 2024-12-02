package com.example.screener.portfolio.fake

import com.example.screener.feature.portfolio.data.PortfolioDataSource
import com.example.screener.feature.portfolio.data.UserHoldingsDto
import kotlinx.serialization.json.Json

class PortfolioFakeApi : PortfolioDataSource {
    override suspend fun getHoldings(): UserHoldingsDto {
        return Json.decodeFromString<UserHoldingsDto>(userHoldingsJson)
    }

    override fun putHoldings(holdings: UserHoldingsDto) {

    }

}