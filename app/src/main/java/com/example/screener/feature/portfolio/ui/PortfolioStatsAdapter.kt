package com.example.screener.feature.portfolio.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.screener.databinding.ItemPortfolioStatsBinding
import com.example.screener.feature.portfolio.state.PortfolioStat

class PortfolioStatsAdapter : ListAdapter<PortfolioStat, PortfolioStatsAdapter.ViewHolder>(
    diffCallback
) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PortfolioStat>() {
            override fun areItemsTheSame(oldItem: PortfolioStat, newItem: PortfolioStat): Boolean {
                return oldItem.label == newItem.label
            }

            override fun areContentsTheSame(
                oldItem: PortfolioStat,
                newItem: PortfolioStat
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ViewHolder(private val binding: ItemPortfolioStatsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(portfolioStat: PortfolioStat) {
            binding.statsIcon.setImageResource(portfolioStat.icon)
            binding.statsTitle.text = binding.root.context.getString(portfolioStat.label)
            binding.statsValue.text = portfolioStat.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPortfolioStatsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}