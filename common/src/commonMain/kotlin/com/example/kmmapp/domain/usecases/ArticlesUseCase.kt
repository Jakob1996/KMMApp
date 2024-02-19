package com.example.kmmapp.domain.usecases

import com.example.kmmapp.domain.entities.Article
import com.example.kmmapp.data.models.ArticleRaw
import com.example.kmmapp.domain.repositories.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val articlesRepository: ArticlesRepository) {

    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articlesRaw = articlesRepository.getArticles(forceFetch)

        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>) = articlesRaw.map { raw ->
        Article(
            raw.title ?: "",
            raw.description ?: "",
            getDaysAgo(raw.date ?: ""),
            raw.imageUrl ?: ""
        )
    }

    private fun getDaysAgo(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}