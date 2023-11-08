package com.example.NoteApp.screens.add

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.NoteApp.Utils
import com.example.NoteApp.ui.theme.NotesTheme
import com.example.NoteApp.ui.theme.Purple40
import com.example.NoteApp.ui.theme.Purple80
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DetailScreen(
    addNoteViewModel: AddNoteViewModel?,
    noteId: String,
    onNavigate: () -> Unit,
) {
    val NoteUiState = addNoteViewModel?.detailUiState ?: DetailUiState()

    val isFormsNotBlank = NoteUiState.note.isNotBlank() &&
            NoteUiState.title.isNotBlank()

    val isNoteIdNotBlank = noteId.isNotBlank()
    val icon = if (isNoteIdNotBlank) Icons.Default.Refresh
    else Icons.Default.Check
    LaunchedEffect(key1 = Unit) {
        if (isNoteIdNotBlank) {
            addNoteViewModel?.getNote(noteId)
        } else {
            addNoteViewModel?.resetState()
        }
    }
    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            AnimatedVisibility(visible = isFormsNotBlank) {
                FloatingActionButton(
                    onClick = {
                        if (isNoteIdNotBlank) {
                            addNoteViewModel?.updateNote(noteId)
                        } else {
                            addNoteViewModel?.addNote()
                        }
                    },
                    backgroundColor = Purple80
                ) {
                    Icon(imageVector = icon, contentDescription = null, tint = Purple40,)
                }
            }
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.secondaryVariant)
                .padding(padding)

        ) {
            if (NoteUiState.noteAddedStatus) {
                scope.launch {
                    scaffoldState.snackbarHostState
                        .showSnackbar("Added Note Successfully")
                    addNoteViewModel?.resetNoteAddedStatus()
                    onNavigate.invoke()
                }
            }

            if (NoteUiState.updateNoteStatus) {
                scope.launch {
                    scaffoldState.snackbarHostState
                        .showSnackbar("Note Updated Successfully")
                    addNoteViewModel?.resetNoteAddedStatus()
                    onNavigate.invoke()
                }
            }
            OutlinedTextField(
                value = NoteUiState.title,
                onValueChange = {
                    addNoteViewModel?.onTitleChange(it)
                },
                label = { Text(text = "Title") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            OutlinedTextField(
                value = NoteUiState.note,
                onValueChange = {
                    addNoteViewModel?.onNoteChange(it)
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                label = { Text(text = "Notes") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(8.dp)
            )


        }


    }


}

@Preview(showSystemUi = true)
@Composable
fun PrevDetailScreen() {
    NotesTheme {
        DetailScreen(addNoteViewModel = null, noteId = "") {

        }
    }

}
