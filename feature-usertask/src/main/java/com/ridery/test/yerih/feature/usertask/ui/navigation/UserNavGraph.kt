package com.ridery.test.yerih.feature.usertask.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ridery.test.yerih.core.sharedViewModel
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.home
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.graph
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signIn
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signup
import com.ridery.test.yerih.feature.usertask.ui.screens.HomeScreen
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.LoginViewModel
import com.ridery.test.yerih.feature.usertask.ui.screens.LoginScreen
import com.ridery.test.yerih.feature.usertask.ui.screens.SignUpScreen

object Routes{

    const val signIn = "main/sign_in"
    const val signup = "main/sign_up"
    const val home = "main/home"
    const val graph = "main"
}
fun NavGraphBuilder.userNavGraph(navController: NavController){
    navigation(
        route = graph,
        startDestination = signIn,
    ){
        composable(route = signIn){
            val viewModel = it.sharedViewModel<LoginViewModel>(navController = navController)
            LoginScreen(
                event = viewModel.event,
                onSignUpClicked = viewModel::onSignUpClicked,
                onLoginClicked = viewModel::onLoginClicked,
                onTaskDone = { route -> navController.navigate(route) }
            )
        }

        composable(route = signup){
            SignUpScreen()
        }

        composable(route = home){
            HomeScreen()
        }
    }

}