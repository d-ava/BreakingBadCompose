package com.example.breakingbadcompose.ui

import com.example.breakingbadcompose.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search
    )


    object Saved : BottomBarScreen(
        route = "saved",
        title = "Saved",
        icon = R.drawable.ic_saved
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile
    )
}
