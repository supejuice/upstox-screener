package com.example.screener.feature.portfolio.usecase

import com.example.screener.R
import com.example.screener.extension.currencyFormat
import com.example.screener.feature.portfolio.data.HoldingRepo
import com.example.screener.feature.portfolio.state.PortfolioStat

class GetPortfolioStatsUseCaseImpl(private val holdingRepo: HoldingRepo) :
    GetPortfolioStatsUseCase {
    override suspend fun invoke(): List<PortfolioStat> {
        try {
            val holdings = holdingRepo.read().data.userHolding
            val currentVal = holdings.sumOf { it.ltp * it.quantity }
            val totalInv = holdings.sumOf { it.avgPrice * it.quantity }
            return listOf(
                PortfolioStat(
                    icon = R.drawable.round_assessment_24,
                    label = R.string.current_value,
                    value = currentVal.currencyFormat()
                ),
                PortfolioStat(
                    icon = R.drawable.round_savings_24,
                    label = R.string.total_inv,
                    value = totalInv.currencyFormat()
                ),
                PortfolioStat(
                    icon = R.drawable.round_insights_24,
                    label = R.string.today_profit_loss,
                    value = (currentVal - totalInv).currencyFormat()
                ),
                PortfolioStat(
                    icon = R.drawable.round_insights_24,
                    label = R.string.profit_loss,
                    value = holdings.sumOf { (it.close - it.ltp) * it.quantity }
                        .currencyFormat()
                )
            )
        } catch (e: Exception) {
            return emptyList()
        }
    }
}

interface GetPortfolioStatsUseCase {
    suspend fun invoke(): List<PortfolioStat>
}