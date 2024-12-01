package com.example.screener.feature.portfolio.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.screener.databinding.ItemHoldingsBinding
import com.example.screener.feature.portfolio.state.Holding

class HoldingsAdapter(private val holdingsList: List<Holding>) : RecyclerView.Adapter<HoldingsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemHoldingsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(holding: Holding) {
            binding.holdingName.text = holding.name
            binding.quantityValue.text = holding.quantity
            binding.ltpValue.text = holding.price
            binding.profitOrLossValue.text = holding.profitAndLoss
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHoldingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return holdingsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val holding = holdingsList[position]
        holder.bind(holding)
    }
}