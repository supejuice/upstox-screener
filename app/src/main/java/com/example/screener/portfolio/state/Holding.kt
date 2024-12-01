package com.example.screener.portfolio.state

/**
 * Represents a holding in a Portfolio.
 */
data class Holding(
    val name: String,
    val quantity: String,
    val price: String,
    val profitAndLoss: String
)