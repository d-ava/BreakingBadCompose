package com.example.breakingbadcompose.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.breakingbadcompose.ui.login.BBTextField
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.uiComponents.BBProgressIndicator
import java.lang.reflect.Modifier
import java.nio.file.Files.size

@Composable
fun SearchScreen(){

    val searchTextState = remember{ mutableStateOf("")}

    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {

Column() {

    BBTextField(text = searchTextState, title ="search" )
}

    }



}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview(){
    SearchScreen()
}

