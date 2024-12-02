package com.example.screener.feature.portfolio.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.screener.feature.portfolio.state.Holding
import com.example.screener.feature.portfolio.state.PortfolioStat
import com.example.screener.feature.portfolio.usecase.GetHoldingsUseCase
import com.example.screener.feature.portfolio.usecase.GetPortfolioStatsUseCase
import kotlinx.coroutines.launch

class PortfolioVewModel(
    private val getHoldingsUseCase: GetHoldingsUseCase,
    private val getPortfolioStatsUseCase: GetPortfolioStatsUseCase
) : ViewModel() {

    private val _holdingsList = MutableLiveData<List<Holding>>()
    val holdingsList: LiveData<List<Holding>> = _holdingsList

    private val _statsList = MutableLiveData<List<PortfolioStat>>()
    val statsList: LiveData<List<PortfolioStat>> = _statsList

    init {
        viewModelScope.launch {
            _holdingsList.value = getHoldingsUseCase.invoke()
            _statsList.value = getPortfolioStatsUseCase.invoke()
        }
    }

    companion object {
        fun factory(
            getHoldingsUseCase: GetHoldingsUseCase,
            getPortfolioStatsUseCase: GetPortfolioStatsUseCase
        ) = viewModelFactory {
            initializer {
                PortfolioVewModel(getHoldingsUseCase, getPortfolioStatsUseCase)
            }
        }
    }
}

