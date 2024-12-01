package com.example.screener.feature.portfolio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.screener.R
import com.example.screener.databinding.FragmentPortfolioBinding
import com.example.screener.extension.container

class PortfolioFragment : Fragment() {

    private val viewModel by viewModels<PortfolioVewModel> {
        PortfolioVewModel.factory(container.portfolioRepo)
    }

    private val binding by lazy { FragmentPortfolioBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.holdingsList.observe(viewLifecycleOwner) { holdingsList ->
            // Update UI
        }
    }
}