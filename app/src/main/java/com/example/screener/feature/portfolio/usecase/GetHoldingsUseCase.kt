package com.example.screener.feature.portfolio.usecase

import com.example.screener.extension.format
import com.example.screener.feature.portfolio.data.HoldingRepo
import com.example.screener.feature.portfolio.state.Holding

fun interface GetHoldingsUseCase {
    suspend fun invoke(): List<Holding>
}

class GetHoldingsUseCaseImpl(private val holdingRepo: HoldingRepo) : GetHoldingsUseCase {
    override suspend fun invoke(): List<Holding> {
        return try {
            holdingRepo.read().data.userHolding.map {
                val pnl = (it.ltp * it.quantity - it.avgPrice * it.quantity)
                Holding(
                    name = it.symbol,
                    quantity = it.quantity.toString(),
                    price = it.ltp.toString(),
                    profitAndLoss = pnl.format(2),
                    isProfit = pnl > 0
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}