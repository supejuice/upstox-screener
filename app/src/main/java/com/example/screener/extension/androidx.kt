package com.example.screener.extension

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.screener.AppContainer
import com.example.screener.MainApplication
import com.example.screener.feature.portfolio.PortfolioContainer

val Fragment.appContainer: AppContainer
    get() = requireActivity().appContainer

val Activity.appContainer: AppContainer
    get() =
        (application as MainApplication).appContainer

val Fragment.portfolioContainer : PortfolioContainer
    get() = appContainer.portfolioContainer