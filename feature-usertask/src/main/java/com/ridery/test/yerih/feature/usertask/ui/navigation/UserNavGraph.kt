package com.ridery.test.yerih.feature.usertask.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ridery.test.yerih.core.sharedViewModel
import com.ridery.test.yerih.feature.usertask.ui.screens.HomeScreen
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.LoginViewModel
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
            val viewModel = it.sharedViewModel<LoginViewModel>(navController = navController)
            LoginScreen(
                event = viewModel.event,
                onSignUpClicked = viewModel::onSignUpClicked,
                onLoginClicked = viewModel::onLoginClicked,
                onTaskDone = { navController.navigate(homeRoute) }
            )
        }

        composable(route = signupRoute){

        }

        composable(route = homeRoute){
            HomeScreen()
        }
    }

}