package com.noahyip.cryptotest.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.noahyip.cryptotest.data.CurrencyData
import com.noahyip.cryptotest.model.CryptoModel
import com.noahyip.cryptotest.model.CurrencyInfo
import com.noahyip.cryptotest.model.FiatModel
import com.noahyip.cryptotest.utils.RoomDatabaseUtil

class DemoActivityViewModel: ViewModel() {
    suspend fun clearData(context: Context): Boolean {
        val rowAffected =  RoomDatabaseUtil.getDatabase(context).currencyDao().deleteAll()
        return rowAffected > 0
    }

    suspend fun insertData(context: Context): Boolean {
        val rowAffected = RoomDatabaseUtil.getDatabase(context).currencyDao().insertAll(getAllData()).size
        return rowAffected > 0
    }

    fun getDataA(): ArrayList<CryptoModel> {
        return CurrencyData.getCryptoList()
    }

    fun getDataB(): ArrayList<FiatModel>{
        return CurrencyData.getFiatList()
    }

    fun getAllData(): ArrayList<CurrencyInfo>{
        val currencyList: ArrayList<CurrencyInfo> = ArrayList()
        currencyList.addAll(CurrencyData.getCryptoList() as ArrayList<CurrencyInfo>)
        currencyList.addAll(CurrencyData.getFiatList() as ArrayList<CurrencyInfo>)
        return currencyList
    }
}