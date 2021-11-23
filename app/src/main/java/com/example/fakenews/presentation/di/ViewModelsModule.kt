package com.example.fakenews.presentation.di

import com.example.fakenews.data.di.DATA_SOURCE_QUALIFIER
import com.example.fakenews.presentation.FragmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        FragmentViewModel(
            interactor = get(qualifier = DATA_SOURCE_QUALIFIER)
        )
    }

}