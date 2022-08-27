package com.example.breakingbadcompose.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.theme.bb_grey_light
import com.example.breakingbadcompose.ui.theme.bb_white
import java.lang.reflect.Modifier
import java.nio.file.Files.size

@Composable
fun LogInScreen(onClick: () -> Unit) {

    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_grey_light)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        Column {
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
                    .clickable { onClick() },
                color = bb_white,
                fontSize = MaterialTheme.typography.h5.fontSize

            )

            TxtField()
        }


    }


}

@Composable
fun TxtField() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(


        value = text,
        onValueChange = { newText ->
            text = newText

        },

//        modifier = androidx.compose.ui.Modifier
//            .border(
//                width = 4.dp,
//                brush = Brush.horizontalGradient(listOf(bb_active_color, bb_active_color)),
//                shape = RoundedCornerShape(32.dp)
//            )
//            .height(64.dp)
//        ,


//        label = {
//            Text(text = "email")
//        },
//        singleLine = true,
//        leadingIcon = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(imageVector = Icons.Filled.Email, contentDescription = "email")
//            }
//        },


    )


}

//@Composable
//@Preview(showBackground = true)
//fun SearchScreenPreview(){
//    LogInScreen()
//}