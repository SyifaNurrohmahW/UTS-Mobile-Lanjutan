package com.example.unscramble.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.jvm.java

@Database (entities =
    [HistoryEntity::class],
    version = 1,
    exportSchema = false) // version di gunakan ketika data berubah maka harus di update

abstract class AppDatabase : RoomDatabase() {

    abstract fun dataDAO(): DataDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "history-word"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

