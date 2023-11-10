package com.ridery.test.yerih.feature.usertask.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.ui.Font
import com.ridery.test.yerih.core.ui.RideryTestTheme
import com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState.Success
import com.ridery.test.yerih.feature.usertask.ui.UserTaskViewModel


@Composable
fun LoginScreen(
    onSave: (user: UserDomain) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp),

            ) {

            Text(
                text = "Welcome",
                style = Font.titleLarge,
                modifier = Modifier.padding(bottom = 50.dp)
            )
            Text(
                text = "Log in",
                style = Font.bodyLarge,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            TextField(
                value = user,
                onValueChange = { user = it },
                label = { Text(text = "User") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 30.dp),
                onClick = {}
            ) {
                Text(text = "Log in")
            }
//            Text(text = "UserTask Screen", textAlign = TextAlign.Center, fontSize = 45.sp)
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
