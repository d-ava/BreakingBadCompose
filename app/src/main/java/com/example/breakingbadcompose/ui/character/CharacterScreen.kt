package com.example.breakingbadcompose.ui.character

import android.text.Layout
import android.util.Log.d
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.model.BBCharacter
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.theme.*
import com.example.breakingbadcompose.ui.uiComponents.FavouriteIcon

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterScreen(navController: NavHostController, vm: HomeViewModel) {


    val result =
        vm.character
//        navController.previousBackStackEntry?.savedStateHandle?.get<BBCharacter>("bb_character")
    val id = result?.charId
    var favourite by rememberSaveable {
        mutableStateOf(vm.favouriteList.contains(id))
    }

    var textColor = if (favourite) bb_background else bb_white

    val scrollState = rememberScrollState()


    val characterQuote = vm.quotes.value.filter { it.author == result?.name }
//    d("------", "character quote - $characterQuote")


    Box(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(if (!favourite) bb_background else bb_active_color)
            .fillMaxSize()
    ) {

        val img = result?.img ?: R.drawable.ic_breaking_bad_logo
        val painter = rememberImagePainter(data = img,
            builder = {
                placeholder(R.drawable.ic_brba_splash)
                error(R.drawable.ic_baseline_error_outline_24)
            })
        val painterState = painter.state


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                stringResource(id = R.string.back),
                color = textColor,
                fontFamily = bbFonts,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 16.dp, top = 16.dp)
                    .clickable { navController.popBackStack() }
            )

            FavouriteIcon(enable = favourite) {

                if (!favourite) {
                    favourite = true
                    vm.addToFavouriteList(result?.charId ?: 0)
                } else {
                    favourite = false
                    vm.removeFromFavouriteList(result?.charId ?: 0)
                }

                d("---", "list - ${vm.favouriteList}")


            }

            Image(
                painter = painter,
                contentDescription = "test",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 64.dp, end = 64.dp, bottom = 16.dp, top = 4.dp)
                    .aspectRatio(0.7f)
                    .fillMaxHeight(0.6f)
            )
            //character name
            Text(
                text = result?.name ?: "Walter White",
                color = textColor,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontFamily = bbFonts

            )
            //nickname
            Text(
                text = result?.nickname ?: "nickname",
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                color = textColor,
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
                color = textColor,
                lineHeight = 24.sp,
                modifier = Modifier
                    .padding(start = 32.dp, top = 16.dp)
            )

            //details
            Text(
                text = stringResource(id = R.string.details),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                color = textColor,
                fontFamily = bbFonts,

                )
            //birthday
            DisplayCharacterDetails(
                title = "Birthday",
                result = result?.birthday,
                color = textColor
            )
            DisplayCharacterDetails(title = "Status", result = result?.status, textColor)
            DisplayCharacterDetails(title = "Portrayed", result = result?.portrayed, textColor)

            Text(
                text = stringResource(id = R.string.quotes),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                color = textColor,
                fontFamily = bbFonts,

                )

            //Quotes
            var quotes = ""
            for (quote in characterQuote) {
                quotes = quotes + quote.quote + "\n" + "\n"
            }

            Text(
                text = quotes,
                color = textColor,
                lineHeight = 24.sp,
                modifier = Modifier
                    .padding(start = 32.dp, top = 16.dp)
            )


        }
    }


}


@Composable
fun DisplayCharacterDetails(title: String, result: String?, color: Color) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(text = title, color = color, modifier = Modifier.padding(start = 32.dp))
        Text(
            text = result ?: "", color = color,
            modifier = Modifier
                .padding(end = 32.dp)
                .align(alignment = Alignment.CenterEnd)
        )

    }


}