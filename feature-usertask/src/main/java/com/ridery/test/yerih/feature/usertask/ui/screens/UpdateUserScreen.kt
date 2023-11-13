package com.ridery.test.yerih.feature.usertask.ui.screens

import android.widget.Toast
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ridery.test.yerih.core.ui.Font
import com.ridery.test.yerih.core.ui.RideryTestTheme
import com.ridery.test.yerih.feature.usertask.ui.presentation.UpdateUserViewModel
import com.ridery.test.yerih.feature.usertask.ui.presentation.UpdateUserViewModel.UiEvent.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun UpdateUserScreen(
    user: String,
    event: Flow<UpdateUserViewModel.UiEvent> = Channel<UpdateUserViewModel.UiEvent>().receiveAsFlow(),
    checkCredentials: (String, String, String)->Unit = {_,_,_->},
    onTaskDone: ()->Unit = {}
){
    val corners = RoundedCornerShape(30.dp)
    var user by remember { mutableStateOf(user) }
    var password by remember { mutableStateOf("password") }
    var confirm by remember { mutableStateOf("password") }
    var passVisible by remember { mutableStateOf(false) }
    var confVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var userError = false
    var passError = false
    var confError = false

    LaunchedEffect(key1 = Unit){
        event.collect{uiEvent ->
            when(uiEvent){
                is NavigateToHome -> onTaskDone()//onTaskDone()
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
                text = "Update user",
                style = Font.titleLarge,
                modifier = Modifier.padding(bottom = 50.dp)
            )

            OutlinedTextField(
                value = user,
                onValueChange = { user = it.trim().also { userError = it.isEmpty() } },
                isError = userError,
                label = { Text(text = if(!userError)"User" else "check here!") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                shape = corners,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it.trim()
                    passError = password.length < 8 },
                isError = passError,
                label = { Text(text = if(!passError)"Password" else "check here!") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                visualTransformation = if(!passVisible) PasswordVisualTransformation() else VisualTransformation.None,
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
            OutlinedTextField(
                value = confirm,
                onValueChange = {
                    confirm = it.trim()
                    confError = confirm != password },
                isError = confError,
                label = { Text(text = if(!confError) "Confirm password" else "check here!") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                visualTransformation = if(!confVisible) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = { confVisible = !confVisible }) {
                        Icon(
                            imageVector = if (confVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = ""
                        )
                    }
                },
                shape = corners,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 30.dp),
                onClick = {checkCredentials(user, password, confirm)}
            ) {
                Text(text = "Update user")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RideryTestTheme {
        UpdateUserScreen("user")
    }
}
