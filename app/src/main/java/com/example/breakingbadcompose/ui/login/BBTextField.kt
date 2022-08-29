package com.example.breakingbadcompose.ui.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_control_color
import com.example.breakingbadcompose.ui.theme.bb_white

@Composable
fun BBTextField(text: MutableState<String>) {

    TextField(
        value = text.value, onValueChange = {
            text.value = it
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
            .border(
                width = 4.dp,
                brush = Brush.horizontalGradient(listOf(bb_active_color, bb_active_color)),
                shape = CircleShape
            )
            .height(64.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = bb_white,
            backgroundColor = Color.Transparent,
            trailingIconColor = Color.Red,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = bb_white,
//            unfocusedLabelColor = Color.Blue


        ),




    )

}