package com.noahyip.cryptotest.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noahyip.cryptotest.model.CurrencyInfo

class CurrencyListFragmentViewModel : ViewModel() {
    val currencyList = MutableLiveData<List<CurrencyInfo>>()
}