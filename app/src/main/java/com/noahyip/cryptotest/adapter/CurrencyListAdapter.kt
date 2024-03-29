package com.noahyip.cryptotest.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noahyip.cryptotest.databinding.ItemCurrencyItemBinding
import com.noahyip.cryptotest.model.CurrencyInfo

class CurrencyListAdapter(private var currencyInfoList: List<CurrencyInfo>?) : RecyclerView.Adapter<CurrencyItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemViewHolder = CurrencyItemViewHolder(
        ItemCurrencyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = currencyInfoList?.size?:0

    override fun onBindViewHolder(holder: CurrencyItemViewHolder, position: Int) {
        currencyInfoList?.get(position)?.let {
            holder.bind(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<CurrencyInfo>?) {
        currencyInfoList = list
        notifyDataSetChanged()
    }

}
class CurrencyItemViewHolder(
    private val binding: ItemCurrencyItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(currencyInfoItem: CurrencyInfo) {
        binding.item = currencyInfoItem
        binding.tvIcon.text = currencyInfoItem.symbol[0].toString()
    }
}