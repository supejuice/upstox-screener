package com.example.screener

import com.example.screener.constants.MainUrls
import com.example.screener.feature.portfolio.PortfolioContainer
import com.example.screener.feature.portfolio.data.HoldingRepo
import com.example.screener.feature.portfolio.data.HoldingRepoImpl
import com.example.screener.feature.portfolio.data.PortfolioCache
import com.example.screener.feature.portfolio.data.PortfolioDataSource
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
            .create(PortfolioDataSource::class.java)
    }
    private val portfolioCache: PortfolioCache by lazy { PortfolioCache() }
    private val holdingRepo: HoldingRepo by lazy {
        HoldingRepoImpl(
            remoteDataSource = portfolioApi,
            cacheDataSource = portfolioCache
        )
    }
    val portfolioContainer get() = PortfolioContainer(holdingRepo)
}