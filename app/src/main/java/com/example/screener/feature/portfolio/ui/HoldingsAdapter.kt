package com.example.screener.feature.portfolio.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.screener.R
import com.example.screener.constants.Strings
import com.example.screener.databinding.ItemHoldingsBinding
import com.example.screener.feature.portfolio.state.Holding

class HoldingsAdapter :
    ListAdapter<Holding, HoldingsAdapter.ViewHolder>(
        diffCallback
    ) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Holding>() {
            override fun areItemsTheSame(oldItem: Holding, newItem: Holding): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Holding, newItem: Holding): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ViewHolder(private val binding: ItemHoldingsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(holding: Holding) {
            binding.holdingName.text = holding.name
            binding.quantityValue.text = buildString {
                append(binding.root.context.getString(R.string.qty))
                append(holding.quantity)
            }
            binding.ltpValue.text = buildString {
                append(Strings.RUPEE)
                append(" ")
                append(holding.price)
            }
            binding.profitOrLossValue.text = buildString {
                append(binding.root.context.getString(R.string.pnl))
                append(holding.profitAndLoss)
            }
            if (holding.isProfit) {
                binding.profitOrLossValue.setTextColor(
                    binding.root.context.getColor(R.color.priceGreen)
                )
            } else {
                binding.profitOrLossValue.setTextColor(
                    binding.root.context.getColor(R.color.priceRed)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHoldingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val holding = currentList[position]
        holder.bind(holding)
    }
}