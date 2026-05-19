package com.example.tanawatk.mvvmandroid.service.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    suspend fun getAll(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(news: List<NewsEntity>)

    @Query("DELETE FROM news")
    suspend fun deleteAll()

    /** Atomically replaces all cached articles in a single transaction. */
    @Transaction
    suspend fun replaceAll(news: List<NewsEntity>) {
        deleteAll()
        insertAll(news)
    }
}
