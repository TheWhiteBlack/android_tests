package com.ridery.test.yerih.feature.usertask.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ridery.test.yerih.feature.usertask.ui.screens.LoginScreen


fun NavGraphBuilder.userNavGraph(navController: NavController){
    val signinRoute = "main/sign_in"
    val signupRoute = "main/sign_up"
    val homeRoute = "main/home"
    val routeGraph = "main"
    navigation(
        route = routeGraph,
        startDestination = signinRoute,
    ){
        composable(route = signinRoute){
            LoginScreen()
        }

        composable(route = signupRoute){
            LoginScreen()
        }

        composable(route = homeRoute){
            LoginScreen()
        }
    }

}