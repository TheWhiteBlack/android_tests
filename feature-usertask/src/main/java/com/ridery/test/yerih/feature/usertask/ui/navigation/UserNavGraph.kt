package com.ridery.test.yerih.feature.usertask.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.sharedViewModel
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.home
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.graph
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signIn
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signup
import com.ridery.test.yerih.feature.usertask.ui.screens.HomeScreen
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.LoginViewModel
import com.ridery.test.yerih.feature.usertask.ui.screens.LoginScreen
import com.ridery.test.yerih.feature.usertask.ui.screens.SignUpScreen
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.SignUpViewModel

object Routes{

    const val signIn = "main/sign_in"
    const val signup = "main/sign_up/${Args.user}"
    const val home = "main/home/{user}"
    const val graph = "main"

    object Args{
        const val user = "{user}"
    }
}


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
fun NavGraphBuilder.userNavGraph(navController: NavController){
    navigation(
        route = graph,
        startDestination = signup,
    ){
        composable(route = signIn){
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
            supViewModel.user = UserDomain(username = it.arguments?.getString("user")?:"")
            SignUpScreen(
                user = supViewModel.user.username,
                event = supViewModel.event,
                checkCredentials = supViewModel::checkCredentials,
                onTaskDone = { navController.popBackStack() }
            )
        }

        composable(route = home){
            HomeScreen()
        }
    }

}