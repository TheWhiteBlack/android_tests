package com.ridery.test.yerih.feature.usertask.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.ui.Font

@Composable
fun HomeScreen(
    user: String,
){

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        ){
        val (welcome, map) = createRefs()
        Text(text = "Welcome to home $user", style = Font.titleLarge, modifier = Modifier.constrainAs(welcome){
            centerTo(parent)
        })
    }
}