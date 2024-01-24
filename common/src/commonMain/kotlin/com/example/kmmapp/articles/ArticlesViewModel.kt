package com.example.kmmapp.articles

import com.example.kmmapp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = fetchArticles()
            delay(500)
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    private suspend fun fetchArticles(): List<Article> {
        return mockArticles
    }

    private val mockArticles = listOf(
        Article(
            "Stock market today: Live updates - CNBC",
            "Futures were higher in premarket trading as Wall Street tried to regain its footing",
            "2023-02-11",
            "https://www.google.com/search?client=avast-a-1&sca_esv=601107417&sxsrf=ACQVn09MOUr8Sf2J63hzZuh_NMZQHKT2_g:1706113800500&q=news&tbm=isch&source=lnms&sa=X&ved=2ahUKEwjMspmYufaDAxUQX_EDHX1iB5cQ0pQJegQICxAB&biw=2560&bih=1291&dpr=1.5#imgrc=zHzlujL5mACCPM"
        ),
        Article(
            "Stock market today: Live updates - CNBC",
            "Futures were higher in premarket trading as Wall Street tried to regain its footing",
            "2023-02-11",
            "https://www.google.com/search?client=avast-a-1&sca_esv=601107417&sxsrf=ACQVn09MOUr8Sf2J63hzZuh_NMZQHKT2_g:1706113800500&q=news&tbm=isch&source=lnms&sa=X&ved=2ahUKEwjMspmYufaDAxUQX_EDHX1iB5cQ0pQJegQICxAB&biw=2560&bih=1291&dpr=1.5#imgrc=pZJv5nGHuAoC-M"
        ),
        Article(
            "Stock market today: Live updates - CNBC",
            "Futures were higher in premarket trading as Wall Street tried to regain its footing",
            "2023-02-11",
            "https://www.google.com/search?client=avast-a-1&sca_esv=601107417&sxsrf=ACQVn09MOUr8Sf2J63hzZuh_NMZQHKT2_g:1706113800500&q=news&tbm=isch&source=lnms&sa=X&ved=2ahUKEwjMspmYufaDAxUQX_EDHX1iB5cQ0pQJegQICxAB&biw=2560&bih=1291&dpr=1.5#imgrc=JxMDZZAuZfjQoM"
        )
    )
}

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)