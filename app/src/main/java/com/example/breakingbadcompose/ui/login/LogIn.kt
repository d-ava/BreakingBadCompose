package com.example.breakingbadcompose.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.theme.bb_white
import java.lang.reflect.Modifier
import java.nio.file.Files.size

@Composable
fun LogInScreen(onClick: ()->Unit){

    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {

Column() {
    Text(
        fontSize = MaterialTheme.typography.h3.fontSize,
        fontWeight = FontWeight.Bold,
        text = "Login Screen",
        color = bb_active_color,
//            modifier = Modifier.clickable {  }
    )

    Text(
        text = "dont have account? register",
        modifier = androidx.compose.ui.Modifier
            .padding(start = 80.dp)
            .clickable {onClick() },
        color = bb_white,
        fontSize = MaterialTheme.typography.h5.fontSize

        )
}



    }



}

//@Composable
//@Preview(showBackground = true)
//fun SearchScreenPreview(){
//    LogInScreen()
//}