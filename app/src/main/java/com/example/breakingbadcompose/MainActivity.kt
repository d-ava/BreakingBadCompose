package com.example.breakingbadcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.breakingbadcompose.ui.MainScreen
import com.example.breakingbadcompose.ui.character.CharacterScreen
import com.example.breakingbadcompose.ui.home.HomeScreen
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.login.LogInScreen
import com.example.breakingbadcompose.ui.theme.BreakingBadComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            val vm: HomeViewModel = viewModel()
            BreakingBadComposeTheme {

//                MainScreen(vm)
                LogInScreen {

                }
            }
        }
    }
}

