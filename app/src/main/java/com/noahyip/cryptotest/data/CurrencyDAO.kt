package com.noahyip.cryptotest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noahyip.cryptotest.model.CurrencyInfo

@Dao
interface CurrencyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(currencyList: ArrayList<CurrencyInfo>): List<Long>

    @Query("DELETE FROM CurrencyInfo")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM CurrencyInfo")
    suspend fun getAll(): List<CurrencyInfo>
}