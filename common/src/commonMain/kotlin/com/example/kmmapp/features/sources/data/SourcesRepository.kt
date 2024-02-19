package com.example.kmmapp.features.sources.data

class SourcesRepository(private val service: SourcesService) {

    suspend fun fetchSources(): List<SourcesRow> {
        return service.fetchSources()
    }
}