package com.example.tanawatk.mvvmandroid.service.model

import com.example.tanawatk.mvvmandroid.base.Model
import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("url")         val url: String?,
    @SerializedName("title")       val title: String?,
    @SerializedName("date")        val date: String?,
    @SerializedName("author_name") val authorName: String?,
    @SerializedName("author_url")  val authorUrl: String?,
    @SerializedName("forum_url")   val forumUrl: String?,
    @SerializedName("image_url")   val imageUrl: String?,
    @SerializedName("comments")    val comments: Int = 0,
    @SerializedName("intro")       val intro: String?
) : Model