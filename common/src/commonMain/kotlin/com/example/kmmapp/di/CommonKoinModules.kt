package com.example.kmmapp.di

import com.example.kmmapp.articles.di.articlesModule

val commonKoinModules = listOf(
    articlesModule,
    networkModule
)