package com.example.news_app

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ArticleAdapter (private val mArticle: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val thumbnail = itemView.findViewById<ImageView>(R.id.imageView)
        val title = itemView.findViewById<TextView>(R.id.titleTextView)
        val content = itemView.findViewById<TextView>(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val articleView = inflater.inflate(R.layout.article, parent, false)
        articleView.setBackgroundColor(Color.GRAY)
        return ViewHolder(articleView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article : Article = mArticle[position]
        val thumbnail = holder.thumbnail

        thumbnail.setImageResource(R.drawable.ic_launcher_foreground)
        Picasso.get().load("https://risibank.fr/cache/stickers/d137/13736-full.png").into(thumbnail)
        val title = holder.title
        title.text = "TEST"
        val content = holder.content
        content.text = "TEST"

    }

    override fun getItemCount(): Int {
        return mArticle.size
    }
}