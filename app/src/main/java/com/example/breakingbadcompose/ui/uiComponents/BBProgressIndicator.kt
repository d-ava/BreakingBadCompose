package com.example.breakingbadcompose.ui.uiComponents

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.theme.bb_active_color

@Composable
fun BBProgressIndicator(){
    CircularProgressIndicator(
        modifier = Modifier.size(64.dp).alpha(0.8f),
        color = bb_active_color,
        strokeWidth = 8.dp,

    )
}