package com.example.breakingbadcompose.ui.character

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.model.BBCharacter
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.theme.bb_white

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterScreen(navController: NavHostController) {
    val result =
        navController.previousBackStackEntry?.savedStateHandle?.get<BBCharacter>("bb_character")
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(bb_background)
            .fillMaxSize()
    ) {

        val img =
            result!!.img
        val painter = rememberImagePainter(data = img,
            builder = {
                placeholder(R.drawable.ic_brba_splash)
                error(R.drawable.ic_baseline_error_outline_24)
            })
        val painterState = painter.state


        Column {
            Text(
                "Back",
                color = bb_white,
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 16.dp, top = 16.dp)
                    .clickable {navController.popBackStack()  }
            )


            Image(
                painter = painter,
                contentDescription = "test",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 64.dp, end = 64.dp, bottom = 16.dp, top = 32.dp)
                    .aspectRatio(0.7f)
                    .fillMaxHeight(0.6f)
            )
            Text(
                text = result.name,
                color = bb_white,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                fontSize = MaterialTheme.typography.h4.fontSize,

                )

        }
    }


//    Column(modifier=Modifier.verticalScroll(scrollState)) {
//    }
}

//@Composable
//@Preview(showBackground = true)
//fun CharacterScreenPreview() {
//    CharacterScreen()
//}