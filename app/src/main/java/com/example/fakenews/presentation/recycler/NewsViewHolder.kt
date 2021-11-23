package com.example.fakenews.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fakenews.R
import kotlinx.android.synthetic.main.item_layout.view.*

class NewsViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): NewsViewHolder {
            return NewsViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
            )
        }
    }

    //title,author,date,topic,text
    private val titleTextView: TextView by lazy { itemView.titleTextView }
    private val authorTextView: TextView by lazy { itemView.authorTextView }
    private val dateTextView: TextView by lazy { itemView.dateTextView }
    private val topicTextView: TextView by lazy { itemView.topicTextView }
    private val textTextView: TextView by lazy { itemView.textTextView }



    private var itemClickListener: ((News) -> Unit)? = null

    fun bindView(item: News) {
        titleTextView.text = item.title
        authorTextView.text = item.author
        dateTextView.text = item.date
        topicTextView.text = item.topic
        textTextView.text = item.text



        itemView.setOnClickListener {

            itemClickListener?.invoke(item)
        }
    }

    fun setItemClickListener(listener: ((News) -> Unit)) {
        itemClickListener = listener
    }
}