package com.example.kmmapp.articles

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