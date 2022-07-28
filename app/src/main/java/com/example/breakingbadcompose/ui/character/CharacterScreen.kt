package com.example.breakingbadcompose.ui.character

import android.text.Layout
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.model.BBCharacter
import com.example.breakingbadcompose.ui.theme.*

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

        val img = result?.img ?: R.drawable.ic_breaking_bad_logo
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
                    .clickable { navController.popBackStack() }
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
            //character name
            Text(
                text = result?.name ?: "Walter White",
                color = bb_white,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontFamily = bbFonts

            )
            //nickname
            Text(
                text = result?.nickname ?: "nickname",
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                color = bb_white,
                fontFamily = bbFonts,
                fontSize = 20.sp
            )
            //occupation
            var occupations = ""

            for (occupation in result?.occupation ?: emptyList()) {
                occupations = occupations + occupation + "\n"
            }
            Text(
                text = occupations,
                color = bb_white,
                lineHeight = 24.sp,
                modifier = Modifier
                    .padding(start = 32.dp, top = 16.dp)
            )

            //details
            Text(
                text = stringResource(id = R.string.details),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                color = bb_white,
                fontFamily = bbFonts,

                )
            //birthday
            DisplayCharacterDetails(title = "Birthday", result = result?.birthday)
            DisplayCharacterDetails(title = "Status", result = result?.status)
            DisplayCharacterDetails(title = "Portrayed", result = result?.portrayed)

//            Row(
//                modifier = Modifier
//                    .padding(start = 32.dp, end = 16.dp, top = 16.dp)
//                    .fillMaxWidth(),
//
//            ) {
//                Text(text = "Birthday", color = bb_white)
//                Text(text = result?.birthday ?: "0", color = bb_white, modifier = Modifier.padding(start = 64.dp))
//            }


        }
    }


}

@Composable
@Preview(showBackground = true)
fun CharacterScreenPreview() {
    CharacterScreen(rememberNavController())
}


@Composable
fun DisplayCharacterDetails(title:String, result:String?, ){
//    Row(
//        modifier = Modifier
//            .padding(start = 32.dp, end = 16.dp, top = 16.dp)
//            .fillMaxWidth(),
//
//        ) {
//        Text(text = title, color = bb_white)
//        Text(text = result ?: "", color = bb_white, modifier = Modifier.padding(start = 64.dp))
//    }

    Box(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        Text(text = title, color = bb_white, modifier = Modifier.padding(start = 32.dp))
        Text(text = result ?:"", color = bb_white,
            modifier = Modifier.padding(end = 32.dp).align(alignment = Alignment.CenterEnd))

    }


}