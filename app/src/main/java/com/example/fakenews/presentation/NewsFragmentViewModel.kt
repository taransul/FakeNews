package com.example.fakenews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News
import kotlinx.coroutines.launch

class NewsFragmentViewModel(
    private val interactor: NewsInteractor
) : ViewModel() {

    private val _transmittingFilteredList = MutableLiveData<List<News>>()
    val transmittingFilteredList: LiveData<List<News>> get() = _transmittingFilteredList

    private val _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>> get() = _newsList

    fun loadMessages(filter: List<News>) {
        viewModelScope.launch {
            _transmittingFilteredList.value = interactor.loadMessages(filter)
        }
    }

    fun newsList() {
        viewModelScope.launch {
            _newsList.value = interactor.newsList()
        }
    }
}