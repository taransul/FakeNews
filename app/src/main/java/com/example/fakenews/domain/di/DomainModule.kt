package com.example.fakenews.domain.di

import com.example.fakenews.data.NewsInteractorImpl
import com.example.fakenews.domain.NewsInteractor2
import org.koin.dsl.module

val domainModule = module {
    single<NewsInteractor2> {
        NewsInteractorImpl(newsDao = get())
    }
}