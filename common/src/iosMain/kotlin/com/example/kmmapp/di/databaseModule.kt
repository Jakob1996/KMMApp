package com.example.kmmapp.di

import com.example.kmmapp.db.DatabaseDriverFactory
import com.example.kmmapp.db.KMMAppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseDriverFactory().createDriver() }

    single { KMMAppDatabase(get()) }
}