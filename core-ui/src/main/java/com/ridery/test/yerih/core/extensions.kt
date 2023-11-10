package com.ridery.test.yerih.core

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController


@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavController,
): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()//return viewModel()
    val parentEntry  = remember(this){ navController.getBackStackEntry(navGraphRoute) }
    return hiltViewModel(parentEntry)
}



fun Any.log(msg: String = "", tag: String = "TGB") = Log.i(tag, msg)

@Composable
fun Toast(msg: String = "toast") = Toast.makeText(LocalContext.current, msg, Toast.LENGTH_SHORT).show()


