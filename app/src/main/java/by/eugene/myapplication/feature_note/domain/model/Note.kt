package by.eugene.myapplication.feature_note.domain.model
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val data: String,
    val time: Long,
    val color: Int,
) {
    companion object {
        val noteColors = listOf(Red, Green, Blue, Yellow, White, Magenta)
    }
}

class InvalidNoteException(message: String): Exception(message)