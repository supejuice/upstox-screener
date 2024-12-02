package com.example.screener.feature.portfolio.data

/**
 * Repo class for managing data sources
 * remote, and in memory caching utilised here
 * */
interface HoldingRepo {
    suspend fun read(): UserHoldingsDto
}

class HoldingRepoImpl(
    private val remoteDataSource: PortfolioDataSource,
    private val cacheDataSource: PortfolioDataSource
) : HoldingRepo {

    /**
     * right now remote api returns static data hence no polling used
     * */
    override suspend fun read(): UserHoldingsDto {
        if (cacheDataSource.getHoldings() == null) {
            cacheDataSource.putHoldings(remoteDataSource.getHoldings()!!)
        }
        return cacheDataSource.getHoldings()!!
    }

}