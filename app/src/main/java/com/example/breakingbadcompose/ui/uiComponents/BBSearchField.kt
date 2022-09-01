package com.example.breakingbadcompose.ui.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.breakingbadcompose.ui.theme.bbFonts
import com.example.breakingbadcompose.ui.theme.bb_control_color
import com.example.breakingbadcompose.ui.theme.bb_white

//@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BBSearchField(text: MutableState<String>) {


    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(top = 8.dp)) {

        val searchTextState = remember{ mutableStateOf(TextFieldValue())}

        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            shape = RoundedCornerShape(16.dp),
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "search icon")
                }
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .height(48.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = bb_white,
                backgroundColor = bb_control_color,
                trailingIconColor = Color.Red,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = bb_white,

            ),
            textStyle = TextStyle.Default.copy(
                fontFamily = bbFonts,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )

        )
    }


}