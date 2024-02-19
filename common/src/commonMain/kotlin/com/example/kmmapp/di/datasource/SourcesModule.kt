package com.example.kmmapp.di.datasource

import com.example.kmmapp.data.datasource.SourcesDataSource
import com.example.kmmapp.domain.repositories.SourcesRepository
import com.example.kmmapp.data.services.SourcesService
import com.example.kmmapp.domain.usecases.SourcesUseCase
import com.example.kmmapp.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single { SourcesRepository(get()) }
    single { SourcesService(get()) }
    single { SourcesUseCase(get()) }
    single { SourcesDataSource(get()) }
    single { SourcesViewModel(get()) }
}