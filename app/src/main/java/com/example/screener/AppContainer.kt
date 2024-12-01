package com.example.screener

import com.example.screener.portfolio.data.PortfolioApi
import com.example.screener.portfolio.data.PortfolioRepo
import retrofit2.Retrofit

/**
 * Dependency Container
 * */
class AppContainer {
    private val portfolioApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .build()
            .create(PortfolioApi::class.java)
    }
    val portfolioRepo by lazy{ PortfolioRepo(remoteDataSource = portfolioApi) }
}