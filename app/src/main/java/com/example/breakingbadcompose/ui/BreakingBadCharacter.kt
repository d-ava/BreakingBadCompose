package com.example.breakingbadcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.breakingbadcompose.R


@OptIn(ExperimentalCoilApi::class)
@Composable
fun BreakingBadCharacterCard(title: String) {
    val painter =
        rememberImagePainter(data = "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg",
            builder = {
//                placeholder(R.drawable.ic_brba_splash)
                crossfade(1000)
                error(R.drawable.ic_baseline_error_outline_24)

            })
    val painterState = painter.state

    Card(
        shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 8.dp, backgroundColor = Color.DarkGray
    ) {
        if (painterState is ImagePainter.State.Loading) {

            LinearProgressIndicator(color = Color.White, modifier = Modifier.alpha(.6f))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painter, contentDescription = null, modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
                    .fillMaxHeight(0.6f),
                contentScale = ContentScale.Crop
            )


            Text(text = title, style = MaterialTheme.typography.h6,color = Color.White,

                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight())
        }

    }

}


