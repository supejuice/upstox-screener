package com.example.screener.extension

fun Double.format(digits: Int) = "%.${digits}f".format(this)