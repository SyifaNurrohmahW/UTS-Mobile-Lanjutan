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
            private var Instance: AppDatabase? = null

            fun getDatabase(context: Context): AppDatabase {
                return Instance ?: synchronized(this) {
                    Room.databaseBuilder(context, AppDatabase::class.java, "history_database")
                        .build()
                        .also { Instance = it }
                }
            }
        }
    }


