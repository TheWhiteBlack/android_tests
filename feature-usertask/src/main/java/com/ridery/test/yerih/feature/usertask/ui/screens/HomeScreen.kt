package com.ridery.test.yerih.feature.usertask.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.ui.Font

@Composable
fun HomeScreen(
    user: String,
){
    Box(
        contentAlignment = Alignment.Center
    ){
        Text(text = "Home", style = Font.titleLarge)
    }
}