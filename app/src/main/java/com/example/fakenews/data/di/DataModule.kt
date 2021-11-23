package com.example.fakenews.data.di

import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.Fragment
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val DATA_SOURCE_QUALIFIER: Qualifier = qualifier("DATA_SOURCE_QUALIFIER")

val dataModule = module {
    single<NewsInteractor>(qualifier = DATA_SOURCE_QUALIFIER) {
        Fragment()
    }
}