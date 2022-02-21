package com.example.news_app

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HeadlinesFragment: Fragment() {

    lateinit var articles: ArrayList<Article>
    lateinit var headlinesView: View
    companion object {
        fun prepare() = HeadlinesFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        headlinesView = inflater.inflate(R.layout.headlines_fragment, container, false)
        val rvArticle = headlinesView.findViewById<RecyclerView>(R.id.headlines_recyclerview)
        articles = Article.createArticleList(10)
        val adapter = ArticleAdapter(articles)
        rvArticle.adapter = adapter
        rvArticle.layoutManager = LinearLayoutManager(container?.context)
        rvArticle.setBackgroundColor(Color.RED)
        return headlinesView
    }
}