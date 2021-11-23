package com.example.fakenews.domain

import com.example.fakenews.presentation.recycler.News

interface NewsInteractor {
    fun loadMessages( filter:List<News>)

    fun loadOrientation(): Int



}