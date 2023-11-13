package com.ridery.test.yerih.feature.usertask.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ridery.test.yerih.core.log
import com.ridery.test.yerih.core.sharedViewModel
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.home
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.graph
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signin
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.signup
import com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.updateUser
import com.ridery.test.yerih.feature.usertask.ui.screens.HomeScreen
import com.ridery.test.yerih.feature.usertask.ui.presentation.LoginViewModel
import com.ridery.test.yerih.feature.usertask.ui.screens.LoginScreen
import com.ridery.test.yerih.feature.usertask.ui.screens.SignUpScreen
import com.ridery.test.yerih.feature.usertask.ui.presentation.HomeViewModel
import com.ridery.test.yerih.feature.usertask.ui.presentation.SignUpViewModel
import com.ridery.test.yerih.feature.usertask.ui.presentation.UpdateUserViewModel
import com.ridery.test.yerih.feature.usertask.ui.screens.UpdateUserScreen

object Routes{

    const val updateUser = "main/update_user/${Args.userId}"
    const val signin = "main/sign_in"
    const val signup = "main/sign_up/${Args.userName}"
    const val home = "main/home/${Args.userId}"
    const val graph = "main"

    object Args{
        const val userId = "{userId}"
        const val userName = "{userName}"
        val userIdAsRoute = userId.replace("{", "").replace("}", "")
        val userNameAsRoute = userName.replace("{", "").replace("}", "")

    }
}


fun NavGraphBuilder.userNavGraph(navController: NavController){
    navigation(
        route = graph,
        startDestination = signin,
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
            supViewModel.user = it.arguments?.getString(Routes.Args.userNameAsRoute)?:""
            SignUpScreen(
                user = supViewModel.user,
                event = supViewModel.event,
                checkCredentials = supViewModel::checkCredentials,
                onTaskDone = { navController.popBackStack() }
            )
        }

        composable(
            route = home,
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ){
            val homeViewModel = it.sharedViewModel<HomeViewModel>(navController)
            homeViewModel.userId = it.arguments?.getInt(Routes.Args.userIdAsRoute)?:-1
            homeViewModel.updateData()
            HomeScreen(
                userId = homeViewModel.userId,
                event = homeViewModel.event,
                onSwipe = homeViewModel::onSwipe,
                onBack = {navController.popBackStack()},
                onEditClicked = {navController.navigate(updateUser
                    .replace(Routes.Args.userId, "${homeViewModel.userId}"))},
                onLogOutClicked = {navController.popBackStack()}
            )
        }

        composable(
            route = updateUser,
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ){
            val updateViewModel = it.sharedViewModel<UpdateUserViewModel>(navController)
            updateViewModel.userId = it.arguments?.getInt(Routes.Args.userIdAsRoute)?:-1
            updateViewModel.updateData()
            UpdateUserScreen(
                username = updateViewModel.username,
                user = updateViewModel.user,
                event = updateViewModel.event,
                checkCredentials = updateViewModel::checkCredentials,
                onTaskDone = { navController.popBackStack() }
            )
        }
    }

}