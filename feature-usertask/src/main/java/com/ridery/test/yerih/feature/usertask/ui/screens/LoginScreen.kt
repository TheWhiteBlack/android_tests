package com.ridery.test.yerih.feature.usertask.ui.screens


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.ui.Font
import com.ridery.test.yerih.core.ui.RideryTestTheme
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes
import com.ridery.test.yerih.feature.usertask.ui.presentation.LoginViewModel
import com.ridery.test.yerih.feature.usertask.ui.presentation.LoginViewModel.UiEvent.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow


@Composable
fun LoginScreen(
    event: Flow<LoginViewModel.UiEvent> = Channel<LoginViewModel.UiEvent>().receiveAsFlow(),
    onLoginClicked: (UserDomain) -> Unit = {},
    onSignUpClicked: (UserDomain) -> Unit = {},
    onTaskDone: (String) -> Unit = { _ -> },
) {
    val corners = RoundedCornerShape(30.dp)
    var user by remember { mutableStateOf("yerih") }
    var password by remember { mutableStateOf("password") }
    var passVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        event.collect { uiEvent ->
            when (uiEvent) {
                is NavigateToHome -> onTaskDone(
                    Routes.home.replace(
                        Routes.Args.userId,
                        uiEvent.user.username
                    )
                )

                is ToastMsg -> Toast.makeText(context, uiEvent.msg, Toast.LENGTH_SHORT).show()
                is NavigateToSignUp -> onTaskDone(
                    Routes.signup.replace(
                        Routes.Args.userName,
                        uiEvent.user.username
                    )
                )
            }
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),

        ) {
        val (group) = createRefs()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.constrainAs(group) { centerTo(parent) }
        ) {

            Text(
                text = "Log in",
                style = Font.titleLarge,
                modifier = Modifier.padding(bottom = 50.dp)
            )
            Text(
                text = "Enter your credentials",
                style = Font.bodyLarge,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            OutlinedTextField(
                value = user,
                onValueChange = { user = it.trim() },
                label = { Text(text = "User") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                shape = corners,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it.trim() },
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                visualTransformation = if (!passVisible) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = { passVisible = !passVisible }) {
                        Icon(
                            imageVector = if (passVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = ""
                        )
                    }
                },
                shape = corners,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Sign up? Click this text",
                style = Font.bodyLarge,
                textAlign = TextAlign.End,
                modifier = Modifier.clickable { onSignUpClicked(UserDomain(user, password)) }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 30.dp),
                onClick = { onLoginClicked(UserDomain(user, password)) }
            ) {
                Text(text = "Log in")
            }
        }
    }
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RideryTestTheme {
        LoginScreen()
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    RideryTestTheme {
        LoginScreen()
    }
}
