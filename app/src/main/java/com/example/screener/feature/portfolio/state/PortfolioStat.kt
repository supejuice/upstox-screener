package com.example.screener.feature.portfolio.state

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PortfolioStat(
    @DrawableRes
    val icon: Int,
    @StringRes
    val label: Int,
    val value: String
)
