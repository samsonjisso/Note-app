package com.samsonjisso.noteapp.di

import android.app.Application
import com.samsonjisso.noteapp.data.NoteDatabase
import com.samsonjisso.noteapp.data.NoteRepository
import com.samsonjisso.noteapp.data.NoteRepositoryImpl
import com.samsonjisso.noteapp.ui.NoteViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { NoteDatabase.getDatabase(get<Application>()) }
    single { get<NoteDatabase>().noteDao() }
    single<NoteRepository> { NoteRepositoryImpl(get()) }
    viewModel { NoteViewModel(get()) }
}