package net.noble.notes_view_try.ViewModel_Screen_Notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(notesVievmodel: Notes_VievModel) {
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        //items(Notes_VievModel.notes){
        items(notesVievmodel.notes){
            Column(modifier = Modifier.fillMaxWidth()){
              Text(text = it.TitleNote)
              Text(text = it.NoteDate)
              Divider()
            }
        }
    }

}