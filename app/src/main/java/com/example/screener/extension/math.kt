package com.example.screener.extension

import java.text.NumberFormat
import java.util.Locale

fun Double.format(digits: Int) = "%.${digits}f".format(this)

fun Double.currencyFormat(): String = run {
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    return currencyFormat.format(this)
}