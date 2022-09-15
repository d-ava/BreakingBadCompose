package com.example.breakingbadcompose.ui.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.breakingbadcompose.ui.theme.bbFonts
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_grey_light
import com.example.breakingbadcompose.ui.theme.bb_white

@Composable
fun FavouriteIcon(enable: Boolean, onClick: () -> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        Icon(
//            imageVector = if (enable) Icons.Filled.Done else Icons.Filled.Close,
//            tint = if (enable) bb_active_color else bb_white,
//            contentDescription = null,
//            modifier = Modifier
//                .size(48.dp)
//                .clickable(
//                    onClick = onClick,
//                    interactionSource = MutableInteractionSource(),
//                    indication = rememberRipple(bounded = false)
//                ),
//
//            )

        Text(
            text = if (enable) "REMOVE" else "ADD",
            fontFamily = bbFonts,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = if (enable)bb_white else bb_active_color,

            modifier = Modifier.clickable (onClick = onClick)
        )
    }

}