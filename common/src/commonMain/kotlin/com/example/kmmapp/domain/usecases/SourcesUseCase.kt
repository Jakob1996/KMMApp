package com.example.kmmapp.domain.usecases

import com.example.kmmapp.domain.entities.Source
import com.example.kmmapp.domain.repositories.SourcesRepository
import com.example.kmmapp.data.models.SourcesRow

class SourcesUseCase(private val repository: SourcesRepository) {

    suspend fun fetchSources(): List<Source> {

        val sources = repository.fetchSources()

        return mapToSources(sources)
    }

    private fun mapToSources(sourcesRawList: List<SourcesRow>) = sourcesRawList.map { raw ->
        Source(
            raw.name ?: "",
            raw.description ?: "",
            raw.url ?: "",
            "${raw.country} - ${raw.language}"
        )
    }
}