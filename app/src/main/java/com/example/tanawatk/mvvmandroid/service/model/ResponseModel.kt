package com.example.tanawatk.mvvmandroid.service.model

import com.example.tanawatk.mvvmandroid.base.Model
import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("request_hash")         val requestHash: String?,
    @SerializedName("request_cached")       val requestCached: Boolean?,
    @SerializedName("request_cache_expiry") val requestCacheExpiry: Int = 0,
    @SerializedName("characters")           val characters: List<Character>?,
    @SerializedName("articles")             val articles: List<News>?
) : Model