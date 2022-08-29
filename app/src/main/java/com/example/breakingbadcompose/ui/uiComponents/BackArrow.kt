package com.example.breakingbadcompose.ui.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.theme.bbFonts
import com.example.breakingbadcompose.ui.theme.bb_white

@Composable
fun BackArrow(onClick: ()-> Unit){
    Text(
        stringResource(id = R.string.back),
        color = bb_white,
        fontFamily = bbFonts,
        modifier = Modifier
            .padding(start = 32.dp, top = 16.dp, bottom = 64.dp)
            .clickable { onClick()}

    )
}