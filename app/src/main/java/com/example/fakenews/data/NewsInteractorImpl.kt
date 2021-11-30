package com.example.fakenews.data

import com.example.fakenews.data.storage.NewsDao
import com.example.fakenews.domain.NewsInteractor2
import com.example.fakenews.presentation.recycler.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsInteractorImpl(private val newsDao: NewsDao) : NewsInteractor2 {
    override suspend fun getNews(): List<News> {
        return withContext(Dispatchers.IO) {
            newsDao.getAll().map { newsEntity -> newsEntity.toUser() }
        }
    }

    override suspend fun insertNews(vararg arrayOfNews: News) {
        withContext(Dispatchers.IO) {
            arrayOfNews
                .map { domainNews -> domainNews.toUserEntity() }
                .forEach { newsEntity -> newsDao.insertUser(newsEntity) }
        }
    }
}