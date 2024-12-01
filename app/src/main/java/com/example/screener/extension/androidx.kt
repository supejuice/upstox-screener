package com.example.screener.extension

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.screener.AppContainer
import com.example.screener.MainApplication

val Fragment.container: AppContainer
    get() = requireActivity().container

val Activity.container: AppContainer
    get() =
        (application as MainApplication).appContainer