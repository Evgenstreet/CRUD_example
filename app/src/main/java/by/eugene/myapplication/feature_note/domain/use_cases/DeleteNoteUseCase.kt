package by.eugene.myapplication.feature_note.domain.use_cases

import by.eugene.myapplication.feature_note.domain.model.Note
import by.eugene.myapplication.feature_note.domain.repository.NoteRepo

class DeleteNoteUseCase(
    private val repo: NoteRepo
){

    suspend operator fun invoke(note: Note){
        repo.deleteNote(note)
    }

}