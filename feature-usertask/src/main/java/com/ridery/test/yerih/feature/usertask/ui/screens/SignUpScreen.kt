package com.ridery.test.yerih.feature.usertask.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.ui.Font
import com.ridery.test.yerih.core.log

@Composable
fun SignUpScreen(
    user: UserDomain,
    onTaskDone: ()->Unit = {}
){
    Log.i("TGB","signup screen: user = $user")
    Box(
        contentAlignment = Alignment.Center
    ){
        Text(text = "Sign Up", style = Font.titleLarge)
    }
}