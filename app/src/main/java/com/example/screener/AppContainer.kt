package com.example.screener

import com.example.screener.constants.MainUrls
import com.example.screener.feature.portfolio.PortfolioContainer
import com.example.screener.feature.portfolio.data.PortfolioApi
import com.example.screener.feature.portfolio.data.PortfolioRepo
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

/**
 * Dependency Container
 * */
class AppContainer {
    private val portfolioApi by lazy {
        Retrofit.Builder()
            .baseUrl(MainUrls.PORTFOLIO)
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .build()
            .create(PortfolioApi::class.java)
    }
    private val portfolioRepo by lazy { PortfolioRepo(remoteDataSource = portfolioApi) }

    val portfolioContainer get() = PortfolioContainer(portfolioRepo)
}