package com.example.kmmapp.di

import com.example.kmmapp.di.datasource.articlesModule
import com.example.kmmapp.di.datasource.sourcesModule

val commonKoinModules = listOf(
    articlesModule,
    networkModule,
    sourcesModule
)