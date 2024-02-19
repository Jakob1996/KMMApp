package com.example.kmmapp.android.di

import com.example.kmmapp.presentation.ArticlesViewModel
import com.example.kmmapp.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }

    viewModel { SourcesViewModel(get()) }
}