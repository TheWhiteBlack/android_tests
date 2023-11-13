package com.ridery.test.yerih.core.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue



@Composable
fun AlertDialogApp(
    title: String = "Title",
    msg: String = "",
    onOkClicked: ()->Unit = {},
    onCancel: ()->Unit = {},
){

    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false; onCancel() },
            title = { Text(title) },
            text = { Text(msg) },
            confirmButton = {
                Button(onClick = { showDialog = false; onOkClicked() }) {
                    Text("Si")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false; onCancel() }) {
                    Text("Cancel")
                }
            }
        )
    }
}

