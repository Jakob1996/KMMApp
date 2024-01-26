package com.example.kmmapp.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    val status: String?,
    @SerialName("totalResults")
    val results: Int?,
    val articles: List<ArticleRaw>?
)

@Serializable
data class ArticleRaw(
    val title: String?,
    val description: String?,
    @SerialName("publishedAt")
    val date: String?,
    @SerialName("urlToImage")
    val imageUrl: String?
)