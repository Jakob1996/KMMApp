package com.example.kmmapp.features.sources.di

import com.example.kmmapp.features.sources.data.SourcesDataSource
import com.example.kmmapp.features.sources.data.SourcesRepository
import com.example.kmmapp.features.sources.data.SourcesService
import com.example.kmmapp.features.sources.domain.SourcesUseCase
import com.example.kmmapp.features.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single { SourcesRepository(get()) }
    single { SourcesService(get()) }
    single { SourcesUseCase(get()) }
    single { SourcesDataSource(get()) }
    single { SourcesViewModel(get()) }
}