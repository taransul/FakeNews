package com.example.fakenews.presentation

import com.example.fakenews.presentation.recycler.News

interface OnChooseFilter {
    fun chooseFilter(filter: List<News>, selectionInformation: String)
}