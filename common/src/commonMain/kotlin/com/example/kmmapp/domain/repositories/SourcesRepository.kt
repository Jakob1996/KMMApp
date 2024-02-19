package com.example.kmmapp.domain.repositories

import com.example.kmmapp.data.models.SourcesRow
import com.example.kmmapp.data.services.SourcesService

class SourcesRepository(private val service: SourcesService) {

    suspend fun fetchSources(): List<SourcesRow> {
        return service.fetchSources()
    }
}