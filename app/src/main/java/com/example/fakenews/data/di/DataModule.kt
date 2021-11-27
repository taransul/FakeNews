package com.example.fakenews.data.di

import com.example.fakenews.data.DataSource
import com.example.fakenews.domain.DataSourceInteractor
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.NewsFragment
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val DATA_SOURCE_QUALIFIER: Qualifier = qualifier("DATA_SOURCE_QUALIFIER")
val DATA_SOURCE_LIST: Qualifier = qualifier("DATA_SOURCE_LIST")

val dataModule = module {
    single<NewsInteractor>(qualifier = DATA_SOURCE_QUALIFIER) {
        NewsFragment()
    }

    single<DataSourceInteractor>(qualifier = DATA_SOURCE_LIST) {
        DataSource()
    }
}