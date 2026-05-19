package com.example.tanawatk.mvvmandroid.service.model

import com.example.tanawatk.mvvmandroid.base.Model
import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("mal_id")    val malId: Int = 0,
    @SerializedName("url")       val url: String?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("name")      val name: String?,
    @SerializedName("role")      val role: String?
) : Model
