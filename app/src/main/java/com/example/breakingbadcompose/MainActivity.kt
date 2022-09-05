package com.example.breakingbadcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.breakingbadcompose.ui.MainScreen
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.theme.BreakingBadComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContent {

            val vm: HomeViewModel = viewModel()
            BreakingBadComposeTheme {


                MainScreen(vm)
//                SearchScreen()
//                LogInScreen {}
//                RegisterScreen()
            }
        }
    }
}

