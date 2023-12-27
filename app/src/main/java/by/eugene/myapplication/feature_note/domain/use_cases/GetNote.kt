package by.eugene.myapplication.feature_note.domain.use_cases

import by.eugene.myapplication.feature_note.domain.model.Note
import by.eugene.myapplication.feature_note.domain.repository.NoteRepo

class GetNote(
    private val repo: NoteRepo
) {

    suspend operator fun invoke(id: Int): Note? {
        return repo.getNoteByID(id)
    }
}