package com.ridery.test.yerih.feature.usertask.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ridery.test.yerih.core.sharedViewModel
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.home
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.graph
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signin
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signup
import com.ridery.test.yerih.feature.usertask.ui.screens.HomeScreen
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.LoginViewModel
import com.ridery.test.yerih.feature.usertask.ui.screens.LoginScreen
import com.ridery.test.yerih.feature.usertask.ui.screens.SignUpScreen
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.SignUpViewModel

object Routes{

    const val signin = "main/sign_in"
    const val signup = "main/sign_up/${Args.user}"
    const val home = "main/home/{user}"
    const val graph = "main"

    object Args{
        const val user = "{user}"
    }
}


fun NavGraphBuilder.userNavGraph(navController: NavController){
    navigation(
        route = graph,
        startDestination = home,
    ){
        composable(route = signin){
            val logViewModel = it.sharedViewModel<LoginViewModel>(navController = navController)
            LoginScreen(
                event = logViewModel.event,
                onSignUpClicked = logViewModel::onSignUpClicked,
                onLoginClicked = logViewModel::onLoginClicked,
                onTaskDone = { route -> navController.navigate(route) }
            )
        }

        composable(route = signup){
            val supViewModel = it.sharedViewModel<SignUpViewModel>(navController)
            supViewModel.user = it.arguments?.getString("user")?:""
            SignUpScreen(
                user = supViewModel.user,
                event = supViewModel.event,
                checkCredentials = supViewModel::checkCredentials,
                onTaskDone = { navController.popBackStack() }
            )
        }

        composable(route = home){
            val homeViewModel = it.sharedViewModel<HomeViewModel>(navController)
            homeViewModel.user = it.arguments?.getString("user")?:""
            HomeScreen(
                user = homeViewModel.user,
                event = homeViewModel.event,
                onSwipe = homeViewModel::onSwipe
            )
        }
    }

}