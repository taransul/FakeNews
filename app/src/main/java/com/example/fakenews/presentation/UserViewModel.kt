package com.example.fakenews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakenews.domain.NewsInteractor2
import com.example.fakenews.presentation.recycler.News
import kotlinx.coroutines.launch

class UserViewModel(
    private val newsInteractor: NewsInteractor2
) : ViewModel() {

    private val _newsTest = MutableLiveData<List<News>>()
    val newsTest: LiveData<List<News>> get() = _newsTest

    fun loadNews() {
        viewModelScope.launch {
            _newsTest.value = newsInteractor.getNews()
        }
    }

    fun insertNews() {
        viewModelScope.launch {
            newsInteractor.insertNews(
                News(
                    "title17",
                    "author1",
                    "26.11.2021",
                    "Политика",
                    "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                            "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                            "критерий для фильтрации."
                )
            )
        }
    }
}