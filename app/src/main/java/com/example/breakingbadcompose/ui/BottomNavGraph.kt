package com.example.breakingbadcompose.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.breakingbadcompose.ui.character.CharacterScreen
import com.example.breakingbadcompose.ui.home.HomeScreen
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.login.LogInScreen
import com.example.breakingbadcompose.ui.profile.ProfileScreen
import com.example.breakingbadcompose.ui.register.RegisterScreen
import com.example.breakingbadcompose.ui.saved.SavedScreen
import com.example.breakingbadcompose.ui.search.SearchScreen
import com.example.breakingbadcompose.util.Graph
import com.google.firebase.auth.FirebaseAuth

@Composable
fun BottomNavGraph(navController: NavHostController, vm: HomeViewModel,) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        route = Graph.HOME
    ) {

        composable(route = BottomBarScreen.Home.route) {

            HomeScreen(vm, navController = navController)
        }

        composable(route = BottomBarScreen.Saved.route) {
            SavedScreen (vm, navController)
        }

        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(vm, navController = navController)
        }

        detailsNavGraph(navController = navController, vm)
        profileNavGraph(navController = navController)

    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController, vm: HomeViewModel) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Character.route
    ) {
        composable(route = DetailsScreen.Character.route) {
            CharacterScreen(navController,vm)
        }

    }
}

fun NavGraphBuilder.profileNavGraph(navController: NavHostController){
    navigation(
        route = Graph.LOGIN,
        startDestination = Profile.Login.route
    ){
        composable(route = Profile.Login.route){
            LogInScreen(navController = navController, onClick = {
                navController.navigate(Profile.Register.route)
            })
        }

        composable(route = Profile.Register.route){
            RegisterScreen(navController,)
        }
    }
}


sealed class DetailsScreen(val route: String) {
    object Character : DetailsScreen(route = "character")

}

sealed class Profile(val route:String){
    object Login: Profile(route = "login")
    object Register: Profile(route= "Register")
}