package com.example.kmmapp.articles

import com.example.kmmapp.db.KMMAppDatabase

class ArticlesDataSource(private val dataBase: KMMAppDatabase) {

    fun getAllArticles() =
        dataBase.dbQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        dataBase.dbQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() = dataBase.dbQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        articleRaw.run {
            dataBase.dbQueries.insertArticle(
                title ?: "",
                description,
                date ?: "",
                imageUrl
            )
        }
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ) = ArticleRaw(
        title,
        desc,
        date,
        url
    )
}