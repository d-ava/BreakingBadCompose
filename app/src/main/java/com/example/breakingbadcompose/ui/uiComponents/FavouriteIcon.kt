package com.example.breakingbadcompose.ui.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_white

@Composable
fun FavouriteIcon(enable: Boolean, onClick: () -> Unit) {
    Icon(
        imageVector = if (enable) Icons.Filled.Add else Icons.Filled.Close,
        tint = if (enable) bb_active_color else bb_white,
        contentDescription = null,
        modifier = Modifier
            .size(48.dp)
            .clickable(
                onClick = onClick,
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(bounded = false)
            ),

    )
}