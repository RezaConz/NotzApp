package com.example.NoteApp.screens.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.NoteApp.components.DividerTextComponent
import com.example.NoteApp.ui.theme.NotesTheme
import com.example.NoteApp.ui.theme.Purple200
import com.example.NoteApp.ui.theme.Purple40
import com.example.NoteApp.ui.theme.dimens

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToSignUpPage:() -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimens.medium2),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.size(MaterialTheme.dimens.medium2))
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.size(MaterialTheme.dimens.large))

        if (isError){
            Text(
                text = loginUiState?.loginError ?: "unknown error",
                color = Color.Red,
            )
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = loginUiState?.userName ?: "",
            onValueChange = {loginViewModel?.onUserNameChange(it)},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            label = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            isError = isError
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = loginUiState?.password ?: "",
            onValueChange = { loginViewModel?.onPasswordNameChange(it) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            label = {
                Text(text = "Password")
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        Spacer(modifier = Modifier.size(MaterialTheme.dimens.superLarge))
        Button(
            onClick = { loginViewModel?.loginUser(context) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple200) ,
            modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Sign In")
        }

        DividerTextComponent()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Belum punya akun?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { onNavToSignUpPage.invoke() }) {
                Text(text = "SignUp", color = Purple40)
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if (loginViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen() {
    NotesTheme {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {

        }
    }
}



