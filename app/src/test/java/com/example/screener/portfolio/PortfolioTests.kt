package com.example.screener.portfolio

import com.example.screener.feature.portfolio.data.HoldingRepo
import com.example.screener.feature.portfolio.data.HoldingRepoImpl
import com.example.screener.feature.portfolio.data.PortfolioCache
import com.example.screener.feature.portfolio.data.PortfolioDataSource
import com.example.screener.feature.portfolio.usecase.GetHoldingsUseCase
import com.example.screener.feature.portfolio.usecase.GetHoldingsUseCaseImpl
import com.example.screener.feature.portfolio.usecase.GetPortfolioStatsUseCase
import com.example.screener.feature.portfolio.usecase.GetPortfolioStatsUseCaseImpl
import com.example.screener.portfolio.fake.PortfolioFakeApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Business Logic unit tests, which will execute on the development machine (host).
 *
 */
class PortfolioTests {

    private val remote: PortfolioDataSource = PortfolioFakeApi()
    private lateinit var cache: PortfolioDataSource
    private lateinit var holdingRepo: HoldingRepo

    @Before
    fun setUp() {
        cache = PortfolioCache()
        holdingRepo = HoldingRepoImpl(remote, cache)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun holdingsValid() = runTest {
        val getHoldingsUseCase: GetHoldingsUseCase = GetHoldingsUseCaseImpl(holdingRepo)
        val holdings = getHoldingsUseCase.invoke()
        assertEquals(holdings.isNotEmpty(), true)
        assertEquals(holdings.find {
            it.name.isEmpty()
        }, null)
        assertEquals(holdings.find {
            it.quantity.toInt() <= 0
        }, null)
        assertEquals(holdings.find {
            it.price.isEmpty()
        }, null)
    }

    @Test
    fun portfolioStatsValid() = runTest {
        val getPortfolioStatsUseCase: GetPortfolioStatsUseCase =
            GetPortfolioStatsUseCaseImpl(holdingRepo)
        val stats = getPortfolioStatsUseCase.invoke()
        assertEquals(stats.isNotEmpty(), true)
        assertEquals(stats.find {
            it.value.isEmpty()
        }, null)
    }
}