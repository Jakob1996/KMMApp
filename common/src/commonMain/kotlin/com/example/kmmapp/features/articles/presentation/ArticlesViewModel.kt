package com.example.kmmapp.features.articles.presentation

import com.example.kmmapp.core.BaseViewModel
import com.example.kmmapp.features.articles.domain.ArticlesUseCase
import com.example.kmmapp.features.articles.domain.Article
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val useCase: ArticlesUseCase) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))

            delay(1000)
            val fetchedArticles = useCase.getArticles(forceFetch)
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)