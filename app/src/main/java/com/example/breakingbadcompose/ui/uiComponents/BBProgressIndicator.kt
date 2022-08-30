package com.example.breakingbadcompose.ui.uiComponents

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.theme.bb_active_color

@Composable
fun BBProgressIndicator(show: Boolean) {

    if (show) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(64.dp)
                    .alpha(0.8f),
                color = bb_active_color,
                strokeWidth = 8.dp,
                )
        }

    }

}