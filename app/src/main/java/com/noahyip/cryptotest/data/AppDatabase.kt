package com.noahyip.cryptotest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noahyip.cryptotest.model.CurrencyInfo

@Database(entities = [CurrencyInfo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDAO
}