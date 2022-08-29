package com.example.breakingbadcompose.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.theme.bb_control_color
import com.example.breakingbadcompose.ui.theme.bb_white

//@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BBTextField(text: MutableState<String>, title:String) {

    //txt field height


    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text =title,
            modifier = Modifier.padding(start = (40).dp, bottom = 8.dp),
            color = bb_white
        )
        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
//                .border(
//                    width = 4.dp,
//                    brush = Brush.horizontalGradient(listOf(bb_active_color, bb_active_color)),
//                    shape = CircleShape
//                )
                .height(64.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = bb_white,
                backgroundColor = bb_control_color,
                trailingIconColor = Color.Red,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = bb_white,

//            unfocusedLabelColor = Color.Blue


            ),
//        keyboardActions = KeyboardActions(onDone = {
//        }),
//        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )
    }


}