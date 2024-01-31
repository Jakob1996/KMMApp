package com.example.kmmapp.sources

class SourcesRepository(private val service: SourcesService) {

    suspend fun fetchSources(): List<SourcesRow> {
        return service.fetchSources()
    }
}