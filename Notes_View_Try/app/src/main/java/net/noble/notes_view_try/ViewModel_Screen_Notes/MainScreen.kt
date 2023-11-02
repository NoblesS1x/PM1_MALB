package net.noble.notes_view_try.ViewModel_Screen_Notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.android.filament.Box

@Composable
fun MainScreen(notesVievmodel: Notes_VievModel) {
    val state = notesVievmodel.state
    if(state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        //items(Notes_VievModel.notes){
        items(state.Notes){
            Column(modifier = Modifier.fillMaxWidth()){
              Text(text = it.TitleNote)
              Text(text = it.NoteDate)
              Divider()
            }
        }
    }

}