package com.example.tanawatk.mvvmandroid.service.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val url: String?,
    val title: String?,
    val date: String?,
    val authorName: String?,
    val imageUrl: String?,
    val intro: String?,
    val comments: Int
)
