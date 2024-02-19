package com.example.kmmapp.data.services

import com.example.kmmapp.api.ApiSettings
import com.example.kmmapp.data.models.ArticleRaw
import com.example.kmmapp.data.models.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient): ApiSettings() {

    private val country = "us"

    private val category = "business"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()

        return response.articles ?: listOf()
    }
}