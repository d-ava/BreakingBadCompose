package com.example.breakingbadcompose.ui.login

import android.util.Log.d
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.theme.*
import com.example.breakingbadcompose.ui.uiComponents.BackArrow
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun LogInScreen(onClick: () -> Unit, navController: NavController) {

    val emailTextState = remember { mutableStateOf("") }
    val passwordTextState = remember { mutableStateOf("") }

    val loginViewModel: LoginViewModel = viewModel()
    val coroutine = rememberCoroutineScope()





    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {

        val image = R.drawable.ic_main_logo
        val painter = rememberImagePainter(data = image)

        Column {
            BackArrow {
                navController.popBackStack()
            }

            Image(
                modifier = androidx.compose.ui.Modifier.padding(
                    start = 64.dp,
                    end = 64.dp,
                    top = 32.dp
                ),
                painter = painter,
                contentDescription = "bb logo",
                alignment = Alignment.Center,
            )

            BBTextField(text = emailTextState, title = "EMAIL")

            BBTextField(text = passwordTextState, title = "PASSWORD")

            BBButton(text = "LOGIN") {
                d("---", "login button pressed")


            }

            Spacer(modifier = androidx.compose.ui.Modifier.height(64.dp))


            Text(
                text = "Don't have an account?",

                color = bb_white,
                fontFamily = bbFonts,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center

            )

            Text(
                text = "REGISTER",
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .clickable { onClick() },
                color = bb_white,
                textAlign = TextAlign.Center,
                fontFamily = bbFonts, fontWeight = FontWeight.Bold, fontSize = 16.sp

            )
        }


    }


}

