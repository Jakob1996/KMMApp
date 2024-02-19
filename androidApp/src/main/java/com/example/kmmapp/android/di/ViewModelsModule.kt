package com.example.kmmapp.android.di

import com.example.kmmapp.features.articles.presentation.ArticlesViewModel
import com.example.kmmapp.features.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }

    viewModel { SourcesViewModel(get()) }
}