package com.example.kmmapp.articles

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val articlesService: ArticlesService
) {

    suspend fun getArticles(): List<ArticleRaw> {
        val articlesDb = dataSource.getAllArticles()

        println("Got ${articlesDb.size} from the database!!")

        if (articlesDb.isEmpty()) {
            val fetchedArticles = articlesService.fetchArticles()

            dataSource.insertArticles(fetchedArticles)

            return fetchedArticles
        }

        return articlesDb
    }
}