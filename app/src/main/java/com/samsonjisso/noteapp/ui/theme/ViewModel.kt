package com.samsonjisso.noteapp.ui.theme

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samsonjisso.noteapp.data.Note
import com.samsonjisso.noteapp.data.NoteRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    private val _notes = mutableStateOf<List<Note>>(emptyList())
    val notes: State<List<Note>> = _notes

    private var getNotesJob: Job? = null

    init {
        getAllNotes()
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    private fun getAllNotes() {
        getNotesJob?.cancel()
        getNotesJob = repository.getAllNotes()
            .map { notesFromDb ->
                _notes.value = notesFromDb
            }
            .launchIn(viewModelScope)
    }

    fun getNoteById(id: Int): Note? {
        // Note: This is a synchronous operation. For larger datasets, consider using Flow.
        return runBlocking { repository.getNoteById(id) }
    }
}