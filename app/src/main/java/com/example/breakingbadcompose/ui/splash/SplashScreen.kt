package com.example.breakingbadcompose.ui.splash

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.MainScreen
import com.example.breakingbadcompose.ui.home.HomeViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreenNavigation(vm:HomeViewModel) {
    val splashNavController = rememberNavController()

    NavHost(navController = splashNavController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(sNavController = splashNavController)
        }
        composable("main_screen") {
            MainScreen(vm)
        }
    }
}

@Composable
fun SplashScreen(sNavController: NavController) {
    val scale = remember {
        Animatable(1f)
    }

    LaunchedEffect(key1 = true) {

        scale.animateTo(
            targetValue = 3f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(0)
        sNavController.navigate("main_screen")
    }



    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_brba_splash),
            contentDescription = "splash logo",
            modifier = Modifier.scale(scale.value)
        )

    }
}

@Composable
fun TestMainScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "TEST MAIN SCREEN")

    }
}
