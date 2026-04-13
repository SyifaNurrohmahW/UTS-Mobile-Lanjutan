package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DataDAO {

    @Insert()
    suspend fun insertHistory(history: HistoryEntity)

    @Query("SELECT * FROM historyData ORDER BY timestamp DESC")
    suspend fun getAllHistory(): List<HistoryEntity>
}