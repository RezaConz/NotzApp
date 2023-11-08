package com.example.NoteApp.screens.Register

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.NoteApp.repository.Auth
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: Auth = Auth(),
) : ViewModel() {
    val currentUser = repository.currentUser

    val hasUser: Boolean
        get() = repository.hasUser()

    var registerUiState by mutableStateOf(RegisterUiState())
        private set

    fun onUserNameChangeSignup(userName: String) {
        registerUiState = registerUiState.copy(userNameSignUp = userName)
    }

    fun onPasswordChangeSignup(password: String) {
        registerUiState = registerUiState.copy(passwordSignUp = password)
    }

    fun onConfirmPasswordChange(password: String) {
        registerUiState = registerUiState.copy(confirmPasswordSignUp = password)
    }

    private fun validateSignupForm() =
        registerUiState.userNameSignUp.isNotBlank() &&
                registerUiState.passwordSignUp.isNotBlank() &&
                registerUiState.confirmPasswordSignUp.isNotBlank()


    fun createUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateSignupForm()) {
                throw IllegalArgumentException("email dan password tidak boleh kosong")
            }
            registerUiState = registerUiState.copy(isLoading = true)
            if (registerUiState.passwordSignUp !=
                registerUiState.confirmPasswordSignUp
            ) {
                throw IllegalArgumentException(
                    "password tidak sama"
                )
            }
            registerUiState = registerUiState.copy(signUpError = null)
            repository.createUser(
                registerUiState.userNameSignUp,
                registerUiState.passwordSignUp,
            ) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(
                        context,
                        "Login berhasil",
                        Toast.LENGTH_SHORT
                    ).show()
                    registerUiState = registerUiState.copy(isSuccessLogin = true)
                } else {
                    Toast.makeText(
                        context,
                        "Login gagal",
                        Toast.LENGTH_SHORT
                    ).show()
                    registerUiState = registerUiState.copy(isSuccessLogin = false)
                }

            }


        } catch (e: Exception) {
            registerUiState = registerUiState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            registerUiState = registerUiState.copy(isLoading = false)
        }


    }

}

data class RegisterUiState(
    val userName: String = "",
    val password: String = "",
    val userNameSignUp: String = "",
    val passwordSignUp: String = "",
    val confirmPasswordSignUp: String = "",
    val isLoading: Boolean = false,
    val isSuccessLogin: Boolean = false,
    val signUpError: String? = null,
    val loginError: String? = null,
)
