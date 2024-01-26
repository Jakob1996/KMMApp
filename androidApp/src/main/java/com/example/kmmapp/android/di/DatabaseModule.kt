package com.example.kmmapp.android.di

import com.example.kmmapp.db.DatabaseDriverFactory
import com.example.kmmapp.db.KMMAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single { DatabaseDriverFactory(androidContext()).createDriver() }

    single { KMMAppDatabase(get()) }
}