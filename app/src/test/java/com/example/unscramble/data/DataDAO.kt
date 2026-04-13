package com.example.unscramble.data

import androidx.room.Query

interface DataDAO {

    @Query("SELECT * FROM historyData")
    suspend fun getallWords(): List<allWord>
}