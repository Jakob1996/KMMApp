package com.example.kmmapp.android.di

import com.example.kmmapp.articles.ArticlesViewModel
import com.example.kmmapp.sources.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }

    viewModel { SourcesViewModel(get()) }
}