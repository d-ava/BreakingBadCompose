package com.example.breakingbadcompose.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import java.lang.reflect.Modifier
import java.nio.file.Files.size

@Composable
fun SearchScreen(){

    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        Text(
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            text = "Search Screen",
            color = bb_active_color
        )

    }



}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview(){
    SearchScreen()
}