package com.example.breakingbadcompose.ui.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.breakingbadcompose.ui.theme.bbFonts
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.theme.bb_white

@Composable
fun BBButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp)
            .height(48.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = bb_background,
            backgroundColor = bb_active_color

        )


        ) {
        Text(text = text, fontFamily = bbFonts, fontWeight = FontWeight.Bold, fontSize = 16.sp )

    }
}