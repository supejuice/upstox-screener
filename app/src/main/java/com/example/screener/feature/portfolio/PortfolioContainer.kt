package com.example.screener.feature.portfolio

import com.example.screener.feature.portfolio.data.PortfolioRepo
import com.example.screener.feature.portfolio.usecase.GetPortfolioUseCaseImpl

class PortfolioContainer (
    private val portfolioRepo: PortfolioRepo
) {
    val getPortfolioUseCase by lazy { GetPortfolioUseCaseImpl(portfolioRepo) }
}