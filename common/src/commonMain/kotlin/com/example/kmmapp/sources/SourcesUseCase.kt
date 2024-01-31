package com.example.kmmapp.sources

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