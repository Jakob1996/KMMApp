package com.example.kmmapp.di.datasource

import com.example.kmmapp.data.datasource.ArticlesDataSource
import com.example.kmmapp.domain.repositories.ArticlesRepository
import com.example.kmmapp.data.services.ArticlesService
import com.example.kmmapp.domain.usecases.ArticlesUseCase
import com.example.kmmapp.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase((get())) }
    single { ArticlesViewModel(get()) }
    single { ArticlesRepository(get(), get()) }
    single { ArticlesDataSource(get()) }
}