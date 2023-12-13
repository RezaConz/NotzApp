package com.example.NoteApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.NoteApp.screens.Login.LoginViewModel
import com.example.NoteApp.screens.Register.RegisterViewModel
import com.example.NoteApp.screens.add.AddNoteViewModel
import com.example.NoteApp.screens.home.HomeViewModel
import com.example.NoteApp.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            val homeViewModel = viewModel( modelClass = HomeViewModel::class.java)
            val addNoteViewModel = viewModel(modelClass = AddNoteViewModel::class.java)
            val registerViewModel = viewModel(modelClass = RegisterViewModel::class.java)
            NotesTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Navigation(
                        loginViewModel = loginViewModel,
                        addNoteViewModel = addNoteViewModel,
                        homeViewModel = homeViewModel,
                        registerViewModel = registerViewModel
                    )
                }
            }
        }
    }
}
