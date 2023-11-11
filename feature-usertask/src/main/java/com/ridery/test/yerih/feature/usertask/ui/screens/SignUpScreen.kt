package com.ridery.test.yerih.feature.usertask.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ridery.test.yerih.core.ui.Font
import com.ridery.test.yerih.core.ui.RideryTestTheme
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.SignUpViewModel
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.SignUpViewModel.UiEvent.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun SignUpScreen(
    user: String,
    event: Flow<SignUpViewModel.UiEvent> = Channel<SignUpViewModel.UiEvent>().receiveAsFlow(),
    checkCredentials: (String, String, String)->Unit = {_,_,_->},
    onTaskDone: ()->Unit = {}
){
    var user by remember { mutableStateOf(user) }
    var password by remember { mutableStateOf("password") }
    var confirm by remember { mutableStateOf("password") }
    val context = LocalContext.current
    var userError = false
    var passError = false
    var confError = false

    LaunchedEffect(key1 = Unit){
        event.collect{uiEvent ->
            when(uiEvent){
                is NavigateToLogIn -> {}//onTaskDone()
                is ToastMsg -> Toast.makeText(context, uiEvent.msg, Toast.LENGTH_SHORT).show()
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
            modifier = Modifier.constrainAs(group){ centerTo(parent)}
        ) {

            Text(
                text = "Sign Up",
                style = Font.titleLarge,
                modifier = Modifier.padding(bottom = 50.dp)
            )

            TextField(
                value = user,
                onValueChange = { user = it.trim().also { userError = it.isEmpty() } },
                isError = userError,
                label = { Text(text = if(!userError)"User" else "check here!") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = password,
                onValueChange = {
                    password = it.trim()
                    passError = password.length < 8 },
                isError = passError,
                label = { Text(text = if(!passError)"Password" else "check here!") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = confirm,
                onValueChange = {
                    confirm = it.trim()
                    confError = confirm != password },
                isError = confError,
                label = { Text(text = if(!confError) "Confirm password" else "check here!") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 30.dp),
                onClick = {checkCredentials(user, password, confirm)}
            ) {
                Text(text = "Sign up")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RideryTestTheme {
        SignUpScreen("user")
    }
}
