package com.example.screener.feature.portfolio

import com.example.screener.feature.portfolio.data.HoldingRepo
import com.example.screener.feature.portfolio.usecase.GetHoldingsUseCaseImpl
import com.example.screener.feature.portfolio.usecase.GetPortfolioStatsUseCaseImpl

/**
 * Dependency container for portfolio feature
 * */
class PortfolioContainer (
    private val holdingRepo: HoldingRepo
) {
    val getPortfolioUseCase by lazy { GetHoldingsUseCaseImpl(holdingRepo) }
    val getPortfolioStatsUseCase by lazy { GetPortfolioStatsUseCaseImpl(holdingRepo) }
}