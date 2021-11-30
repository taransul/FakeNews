package com.example.fakenews.domain

import com.example.fakenews.presentation.recycler.News

interface NewsInteractor2 {
    suspend fun getNews(): List<News>

    suspend fun insertNews(vararg arrayOfNews: News)
}