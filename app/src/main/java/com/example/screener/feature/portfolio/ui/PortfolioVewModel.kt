package com.example.screener.feature.portfolio.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.screener.feature.portfolio.state.Holding
import com.example.screener.feature.portfolio.usecase.GetPortfolioUseCase
import kotlinx.coroutines.launch

class PortfolioVewModel(
    private val getPortfolioUseCase: GetPortfolioUseCase
) : ViewModel() {

    private val _holdingsList = MutableLiveData<List<Holding>>()
    val holdingsList: LiveData<List<Holding>> = _holdingsList

    init {
        viewModelScope.launch {
            _holdingsList.value = getPortfolioUseCase.getPortfolio()
        }
    }

    companion object {
        fun factory(getPortfolioUseCase: GetPortfolioUseCase) = viewModelFactory {
            initializer {
                PortfolioVewModel(getPortfolioUseCase)
            }
        }
    }
}

