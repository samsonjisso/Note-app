package com.samsonjisso.noteapp

import android.app.Application
import com.samsonjisso.noteapp.di.appModule
import org.koin.core.context.startKoin

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}