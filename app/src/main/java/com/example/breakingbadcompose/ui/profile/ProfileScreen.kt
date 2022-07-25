package com.example.breakingbadcompose.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background

@Composable
fun ProfileScreen(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        Text(
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            text = "Profile Screen",
            color = bb_active_color
        )

    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen {

    }
}