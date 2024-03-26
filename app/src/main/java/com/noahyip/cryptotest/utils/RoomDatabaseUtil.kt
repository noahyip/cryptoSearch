package com.noahyip.cryptotest.utils

import android.content.Context
import androidx.room.Room
import com.noahyip.cryptotest.AppDatabase

class RoomDatabaseUtil {
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database"
        ).build()
    }
}