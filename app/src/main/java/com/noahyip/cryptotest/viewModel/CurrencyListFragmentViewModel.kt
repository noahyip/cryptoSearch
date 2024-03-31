package com.noahyip.cryptotest.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noahyip.cryptotest.model.CurrencyInfo

class CurrencyListFragmentViewModel : ViewModel() {
    var currencyList: List<CurrencyInfo> = emptyList()
    val resultCurrencyList = MutableLiveData<List<CurrencyInfo>>()
    val isEditing = MutableLiveData(false)

    fun getResultList(): List<CurrencyInfo>? {
        resultCurrencyList.value = currencyList
        return resultCurrencyList.value
    }
    fun search(keyword: String) {
        val resultList = ArrayList<CurrencyInfo>()
        for (currency in currencyList) {
            if (currency.id.lowercase().startsWith(keyword.lowercase())) resultList.add(currency)

            val splitName = currency.name.split(" ")
            for (ns in splitName) {
                if (ns.lowercase().startsWith(keyword.lowercase())) resultList.add(currency)
            }
        }
        resultCurrencyList.value = resultList
    }
}