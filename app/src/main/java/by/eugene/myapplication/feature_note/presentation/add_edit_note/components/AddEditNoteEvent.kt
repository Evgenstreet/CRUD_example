package by.eugene.myapplication.feature_note.presentation.add_edit_note.components

import androidx.compose.ui.focus.FocusState

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class ChangeTitle(val focusState: FocusState): AddEditNoteEvent()
    data class EnteredData(val value: String): AddEditNoteEvent()
    data class ChangeData(val focusState: FocusState): AddEditNoteEvent()
    data class ChangeColor(val color: Int): AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}