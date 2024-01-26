package com.example.kmmapp.articles.di

import com.example.kmmapp.articles.ArticlesDataSource
import com.example.kmmapp.articles.ArticlesRepository
import com.example.kmmapp.articles.ArticlesService
import com.example.kmmapp.articles.ArticlesUseCase
import com.example.kmmapp.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single { ArticlesService(get()) }
    single { ArticlesUseCase((get())) }
    single { ArticlesViewModel(get()) }
    single { ArticlesRepository(get(), get()) }
    single { ArticlesDataSource(get()) }
}