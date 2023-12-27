package by.eugene.myapplication.feature_note.domain.use_cases

data class NotesUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNote: AddNote,
    val getNote: GetNote,
)