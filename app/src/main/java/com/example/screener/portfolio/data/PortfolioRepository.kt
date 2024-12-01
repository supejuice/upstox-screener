package com.example.screener.portfolio.data

/**
 * Repo class for managing data sources
 * */
class PortfolioRepo(
    private val remoteDataSource: PortfolioApi
) {

    suspend fun getPortfolio(): PortfolioResponse {
        return remoteDataSource.getPortfolio()
    }

}