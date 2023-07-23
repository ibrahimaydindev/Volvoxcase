package com.ibrahimaydindev.volvoxcase.di

import android.app.Application
import com.ibrahimaydindev.volvoxcase.database.NewsDatabase
import com.ibrahimaydindev.volvoxcase.repository.NewsRepository
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModelProviderFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class NewsApplication: Application(),KodeinAware{
    override val kodein: Kodein =  Kodein.lazy {
        import(androidXModule(this@NewsApplication))
        bind() from singleton { NewsDatabase(instance()) }
        bind() from singleton { NewsRepository(instance()) }
        bind() from provider {
            NewsViewModelProviderFactory(instance())
        }
    }
}

