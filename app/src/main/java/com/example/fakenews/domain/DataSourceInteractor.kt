package com.example.fakenews.domain

import com.example.fakenews.presentation.recycler.News

interface DataSourceInteractor {
    fun newsList(): List<News>
}