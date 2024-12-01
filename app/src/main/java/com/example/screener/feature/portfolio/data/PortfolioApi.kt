package com.example.screener.feature.portfolio.data

import retrofit2.http.GET

interface PortfolioApi {
    @GET("/")
    suspend fun getPortfolio() : PortfolioResponse
}