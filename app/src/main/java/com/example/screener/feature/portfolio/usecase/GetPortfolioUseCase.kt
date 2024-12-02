package com.example.screener.feature.portfolio.usecase

import com.example.screener.extension.format
import com.example.screener.feature.portfolio.data.PortfolioRepo
import com.example.screener.feature.portfolio.state.Holding

fun interface GetPortfolioUseCase {
    suspend fun getPortfolio(): List<Holding>
}

class GetPortfolioUseCaseImpl(private val portfolioRepo: PortfolioRepo) : GetPortfolioUseCase {
    override suspend fun getPortfolio(): List<Holding> {
        return portfolioRepo.getPortfolio().data.userHolding.map {
            val pnl = (it.ltp * it.quantity - it.avgPrice * it.quantity)
            Holding(
                name = it.symbol,
                quantity = it.quantity.toString(),
                price = it.ltp.toString(),
                profitAndLoss = pnl.format(2),
                isProfit = pnl > 0
            )
        }
    }
}