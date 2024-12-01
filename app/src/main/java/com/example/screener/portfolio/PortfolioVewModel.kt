package com.example.screener.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.screener.portfolio.data.PortfolioRepo
import com.example.screener.portfolio.data.PortfolioResponse
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

}