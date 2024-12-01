package com.example.screener.portfolio.data

import retrofit2.http.GET

interface PortfolioApi {
    @GET
    suspend fun getPortfolio() : PortfolioResponse
}