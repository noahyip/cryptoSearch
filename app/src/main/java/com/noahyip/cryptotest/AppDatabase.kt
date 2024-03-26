package com.noahyip.cryptotest

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noahyip.cryptotest.model.CurrencyDao
import com.noahyip.cryptotest.model.CurrencyModel

@Database(entities = [CurrencyModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}