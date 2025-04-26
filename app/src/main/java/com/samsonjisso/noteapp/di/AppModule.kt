package com.samsonjisso.noteapp.di

import android.app.Application
import androidx.lifecycle.viewmodel.viewModelFactory
import com.samsonjisso.noteapp.data.NoteDatabase
import com.samsonjisso.noteapp.data.NoteRepository
import com.samsonjisso.noteapp.data.NoteRepositoryImpl
import com.samsonjisso.noteapp.ui.theme.NoteViewModel
import org.koin.dsl.module


val appModule = module {
    single { NoteDatabase.getDatabase(get<Application>()) }
    single { get<NoteDatabase>().noteDao() }
    single<NoteRepository> { NoteRepositoryImpl(get()) }
   viewModel
}