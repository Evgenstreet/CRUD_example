package by.eugene.myapplication.di

import android.app.Application
import androidx.room.Room
import by.eugene.myapplication.feature_note.data.data_source.NoteDB
import by.eugene.myapplication.feature_note.data.repository.NoteRepoImpl
import by.eugene.myapplication.feature_note.domain.repository.NoteRepo
import by.eugene.myapplication.feature_note.domain.use_cases.AddNote
import by.eugene.myapplication.feature_note.domain.use_cases.DeleteNoteUseCase
import by.eugene.myapplication.feature_note.domain.use_cases.GetNote
import by.eugene.myapplication.feature_note.domain.use_cases.GetNotesUseCase
import by.eugene.myapplication.feature_note.domain.use_cases.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDB {
        return Room.databaseBuilder(app, NoteDB::class.java, NoteDB.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepo(db: NoteDB): NoteRepo {
        return NoteRepoImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repo: NoteRepo): NotesUseCases {
        return NotesUseCases(
            getNotes = GetNotesUseCase(repo),
            deleteNote = DeleteNoteUseCase(repo),
            addNote = AddNote(repo),
            getNote = GetNote(repo),
        )
    }
}