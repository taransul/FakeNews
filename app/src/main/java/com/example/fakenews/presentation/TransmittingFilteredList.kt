package com.example.fakenews.presentation

import com.example.fakenews.presentation.recycler.News

interface TransmittingFilteredList {
    fun passesFilteredList(filter: List<News>, selectionInformation: String)
}