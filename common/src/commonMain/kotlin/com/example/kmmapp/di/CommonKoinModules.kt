package com.example.kmmapp.di

import com.example.kmmapp.features.articles.di.articlesModule
import com.example.kmmapp.features.sources.di.sourcesModule

val commonKoinModules = listOf(
    articlesModule,
    networkModule,
    sourcesModule
)