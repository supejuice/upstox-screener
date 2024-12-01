package com.example.screener.feature.portfolio.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.screener.feature.portfolio.data.PortfolioRepo
import com.example.screener.feature.portfolio.data.PortfolioResponse
import kotlinx.coroutines.launch

class PortfolioVewModel(
    private val portfolioRepo: PortfolioRepo
) : ViewModel() {

    private val _holdingsList = MutableLiveData<PortfolioResponse>()
    val holdingsList: LiveData<PortfolioResponse> = _holdingsList

    init {
        viewModelScope.launch {
            _holdingsList.value = portfolioRepo.getPortfolio()
        }
    }

    companion object {
        fun factory(portfolioRepo: PortfolioRepo) = viewModelFactory {
            initializer {
                PortfolioVewModel(portfolioRepo = portfolioRepo)
            }
        }
    }
}

