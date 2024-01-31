package com.example.kmmapp.sources

import com.example.kmmapp.ApiSettings
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(
    private val httpClient: HttpClient
) : ApiSettings() {

    suspend fun fetchSources(): List<SourcesRow> {
        val response: SourcesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()

        return response.sources
    }
}