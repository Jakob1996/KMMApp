package com.example.kmmapp.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"

    private val category = "business"

    private val apiKey = "fc0f44d0499d4244b4f2b02000e697c1"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()

        return response.articles ?: listOf()
    }
}