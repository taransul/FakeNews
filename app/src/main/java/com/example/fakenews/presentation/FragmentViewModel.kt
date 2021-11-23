package com.example.fakenews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentViewModel(private val interactor: NewsInteractor) : ViewModel() {

    private val _onFilterChoose = MutableLiveData<List<News>>()
    val onFilterChoose: LiveData<List<News>> get() = _onFilterChoose

    private val _listOrientation = MutableLiveData(interactor.loadOrientation())
    val listOrientation: LiveData<Int> get() = _listOrientation

    private val scope = CoroutineScope(Dispatchers.Main)

    fun loadMessages(filter: List<News>) {
        scope.launch {
            _onFilterChoose.value = filter
        }
    }
}