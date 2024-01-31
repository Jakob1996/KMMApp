package com.example.kmmapp.sources.di

import com.example.kmmapp.sources.SourcesDataSource
import com.example.kmmapp.sources.SourcesRepository
import com.example.kmmapp.sources.SourcesService
import com.example.kmmapp.sources.SourcesUseCase
import com.example.kmmapp.sources.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single { SourcesRepository(get()) }
    single { SourcesService(get()) }
    single { SourcesUseCase(get()) }
    single { SourcesDataSource(get()) }
    single { SourcesViewModel(get()) }
}