package com.example.kmmapp.features.articles.di

import com.example.kmmapp.features.articles.data.ArticlesDataSource
import com.example.kmmapp.features.articles.data.ArticlesRepository
import com.example.kmmapp.features.articles.data.ArticlesService
import com.example.kmmapp.features.articles.domain.ArticlesUseCase
import com.example.kmmapp.features.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single { ArticlesService(get()) }
    single { ArticlesUseCase((get())) }
    single { ArticlesViewModel(get()) }
    single { ArticlesRepository(get(), get()) }
    single { ArticlesDataSource(get()) }
}