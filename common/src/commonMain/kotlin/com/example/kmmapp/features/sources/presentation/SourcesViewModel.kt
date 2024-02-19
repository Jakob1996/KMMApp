package com.example.kmmapp.features.sources.presentation

import com.example.kmmapp.core.BaseViewModel
import com.example.kmmapp.features.sources.domain.Source
import com.example.kmmapp.features.sources.domain.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(private val useCase: SourcesUseCase) : BaseViewModel() {

    private val _sourcesState: MutableStateFlow<SourcesState> = MutableStateFlow(SourcesState())
    val sourcesState: StateFlow<SourcesState> get() = _sourcesState

    init {
        fetchSource()
    }

    private fun fetchSource() {
        scope.launch {
            val sources = useCase.fetchSources()

            _sourcesState.emit(SourcesState(sources = sources))
        }
    }
}

data class SourcesState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)