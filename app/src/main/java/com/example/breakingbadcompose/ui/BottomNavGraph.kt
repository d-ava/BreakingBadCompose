package com.example.breakingbadcompose.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.breakingbadcompose.ui.home.HomeScreen
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.profile.ProfileScreen
import com.example.breakingbadcompose.ui.saved.SavedScreen
import com.example.breakingbadcompose.ui.search.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController, vm: HomeViewModel){
    NavHost(navController = navController,
    startDestination = BottomBarScreen.Home.route){

        composable(route=BottomBarScreen.Home.route){

            HomeScreen(vm)
        }

        composable(route=BottomBarScreen.Saved.route){
            SavedScreen {}
        }

        composable(route=BottomBarScreen.Search.route){
            SearchScreen()
        }
        composable(route=BottomBarScreen.Profile.route){
            ProfileScreen {

            }
        }



    }
}