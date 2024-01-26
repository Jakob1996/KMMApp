package com.example.kmmapp.android.di

import com.example.kmmapp.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {ArticlesViewModel(get())}
}