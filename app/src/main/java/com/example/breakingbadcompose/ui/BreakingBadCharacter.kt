package com.example.breakingbadcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.breakingbadcompose.ui.theme.bbFonts


@OptIn(ExperimentalCoilApi::class)
@Composable
fun BreakingBadCharacterCard(title: String, img:String, category:String, onClick:()->Unit) {
    val painter =
        rememberImagePainter(data = img,
            builder = {
                if (category.lowercase().contains("s") && category.lowercase().contains("d") ){
                    placeholder(R.drawable.ic_main_logo)
                }else if (category.lowercase().contains("s")){
                    placeholder(R.drawable.ic_better_cal_saul_logo)
                }else{
                    placeholder(R.drawable.ic_brba_splash)
                }

                crossfade(1000)
                error(R.drawable.ic_baseline_error_outline_24)

            })
    val painterState = painter.state

    Card(
        shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
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


            Text(text = title,color = Color.White,

                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight(), fontFamily = bbFonts)
        }

    }

}


