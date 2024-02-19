package com.example.kmmapp.domain.repositories

import com.example.kmmapp.data.datasource.ArticlesDataSource
import com.example.kmmapp.data.models.ArticleRaw
import com.example.kmmapp.data.services.ArticlesService

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val articlesService: ArticlesService
) {
    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {

        if (forceFetch) {
            dataSource.clearArticles()
            fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()

        println("Got ${articlesDb.size} from the database!!")

        if (articlesDb.isEmpty()) {
            return fetchArticles()
        }

        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = articlesService.fetchArticles()

        dataSource.insertArticles(fetchedArticles)

        return fetchedArticles
    }
}