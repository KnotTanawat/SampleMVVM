package com.example.tanawatk.mvvmandroid.service.repo.local

import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.db.NewsDao
import com.example.tanawatk.mvvmandroid.service.db.NewsEntity
import com.example.tanawatk.mvvmandroid.service.model.News
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel
import com.example.tanawatk.mvvmandroid.service.repo.LocalDataSource
import javax.inject.Inject

class NewsLocalDataSource @Inject constructor(
    private val newsDao: NewsDao
) : LocalDataSource {

    override suspend fun loadFromCache(): Result<ResponseModel> {
        val entities = newsDao.getAll()
        return if (entities.isEmpty()) {
            Result.Error(0, "Cache empty")
        } else {
            Result.Success(ResponseModel(null, null, 0, null, entities.map { it.toNews() }))
        }
    }

    override suspend fun replaceCache(model: ResponseModel) {
        val entities = model.articles?.map { it.toEntity() } ?: return
        newsDao.replaceAll(entities)  // single @Transaction — no gap between clear and insert
    }

    private fun NewsEntity.toNews() = News(
        url = url, title = title, date = date,
        authorName = authorName, authorUrl = null, forumUrl = null,
        imageUrl = imageUrl, comments = comments, intro = intro
    )

    private fun News.toEntity() = NewsEntity(
        url = url, title = title, date = date,
        authorName = authorName, imageUrl = imageUrl,
        intro = intro, comments = comments
    )
}