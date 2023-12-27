package by.eugene.myapplication.feature_note.domain.use_cases

import by.eugene.myapplication.feature_note.domain.model.InvalidNoteException
import by.eugene.myapplication.feature_note.domain.model.Note
import by.eugene.myapplication.feature_note.domain.repository.NoteRepo
import kotlin.jvm.Throws

class AddNote (
    private val repo: NoteRepo
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()){
            throw InvalidNoteException("Title can't be empty!!")
        }
        if(note.data.isBlank()){
            throw InvalidNoteException("Note can't be empty!!")
        }
        repo.insertNote(note)
    }
}