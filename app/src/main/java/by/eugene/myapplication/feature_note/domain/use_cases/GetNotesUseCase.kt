package by.eugene.myapplication.feature_note.domain.use_cases

import by.eugene.myapplication.feature_note.domain.model.Note
import by.eugene.myapplication.feature_note.domain.repository.NoteRepo
import by.eugene.myapplication.feature_note.domain.util.NoteOrder
import by.eugene.myapplication.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repo: NoteRepo
) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>>{
        return repo.getNotes().map { notes -> when(noteOrder.order) {
            is OrderType.Ascending -> {
                when(noteOrder) {
                    is NoteOrder.Title -> {
                        notes.sortedBy { it.title.lowercase() }
                    }
                    is NoteOrder.Date-> {
                        notes.sortedBy { it.time}
                    }
                    is NoteOrder.Color -> {
                        notes.sortedBy { it.color}
                    }
                }
            }
            is OrderType.Descending -> {
                when(noteOrder) {
                    is NoteOrder.Title -> {
                        notes.sortedByDescending { it.title.lowercase() }
                    }
                    is NoteOrder.Date-> {
                        notes.sortedByDescending { it.time}
                    }
                    is NoteOrder.Color -> {
                        notes.sortedByDescending { it.color}
                    }
                }
            }
        } }
    }
}