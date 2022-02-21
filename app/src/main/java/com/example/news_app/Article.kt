package com.example.news_app

class Article(val name: String, val isOnline: Boolean) {
    companion object {
        private var lastArticleId = 0
        fun createArticleList(numArticles: Int) : ArrayList<Article> {
            val articles = ArrayList<Article>()
            for (i in 1..numArticles) {
                articles.add(Article("Article " + ++lastArticleId, i <= numArticles / 2))
            }
            return articles
        }
    }
}