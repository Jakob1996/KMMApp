package com.example.kmmapp.di

import com.example.kmmapp.articles.di.articlesModule
import com.example.kmmapp.sources.di.sourcesModule

val commonKoinModules = listOf(
    articlesModule,
    networkModule,
    sourcesModule
)