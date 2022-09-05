package com.example.breakingbadcompose.ui.register

import android.util.Log.d
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.login.BBButton
import com.example.breakingbadcompose.ui.login.BBTextField
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.uiComponents.BackArrow
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.reflect.Modifier
import java.nio.file.Files.size

@Composable
fun RegisterScreen(navController:NavHostController) {

    val auth = Firebase.auth

    val emailTextState = remember { mutableStateOf("") }
    val nameTextState = remember { mutableStateOf("") }
    val passwordTextState = remember { mutableStateOf("") }
    val repeatPasswordTextState = remember { mutableStateOf("") }


    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {


        Column() {
            BackArrow {
                navController.popBackStack()

            }

            BBTextField(text = emailTextState, title = stringResource(id = R.string.email))
            BBTextField(text = nameTextState, title = stringResource(id = R.string.name))
            BBTextField(text = passwordTextState, title = stringResource(id = R.string.password))
            BBTextField(
                text = repeatPasswordTextState,
                title = stringResource(id = R.string.repeat_password)
            )
            BBButton(stringResource(id = R.string.register)) {
//                auth.createUserWithEmailAndPassword(
//                    emailTextState.value,
//                    passwordTextState.value
//                ).addOnCompleteListener(){task ->
//                    if (task.isSuccessful){
//                        d("---", "success, registered new user")
//                    }else{
//                        d("---", "error, registered new user failed")
//                    }
//
//                }

            }

        }


    }


}

//@Composable
//@Preview(showBackground = true)
//fun SearchScreenPreview(){
//    LogInScreen()
//}