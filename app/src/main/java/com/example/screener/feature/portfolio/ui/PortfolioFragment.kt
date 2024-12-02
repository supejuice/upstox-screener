package com.example.screener.feature.portfolio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.screener.databinding.FragmentPortfolioBinding
import com.example.screener.extension.portfolioContainer

class PortfolioFragment : Fragment() {

    private val viewModel by viewModels<PortfolioVewModel> {
        PortfolioVewModel.factory(
            portfolioContainer.getPortfolioUseCase,
            portfolioContainer.getPortfolioStatsUseCase
        )
    }

    private val binding by lazy { FragmentPortfolioBinding.inflate(layoutInflater) }
    private val adapter by lazy { HoldingsAdapter() }
    private val statsAdapter by lazy { PortfolioStatsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.statsCarousel.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.statsCarousel.adapter = statsAdapter
        binding.holdingsList.adapter = adapter
        binding.holdingsList.layoutManager = LinearLayoutManager(requireContext())
        viewModel.holdingsList.observe(viewLifecycleOwner) { holdingsList ->
            adapter.submitList(holdingsList)
        }
        viewModel.statsList.observe(viewLifecycleOwner) {
            statsAdapter.submitList(it)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }
}