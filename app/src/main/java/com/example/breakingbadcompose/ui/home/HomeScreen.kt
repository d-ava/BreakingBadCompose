package com.example.breakingbadcompose.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.BreakingBadCharacterCard
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.theme.bb_white

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
//    charactersViewModel:HomeViewModel = viewModel()
charactersViewModel:HomeViewModel

) {



    Box(
        modifier = Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        Column() {
            Text(

                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
//                fontFamily = ,
                text = "Characters",
                color = bb_white,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)

                )

            LazyVerticalGrid( cells = GridCells.Fixed(2), content = {
                items(charactersViewModel.characters.value,) { character ->

                    BreakingBadCharacterCard(title = character.name, img = character.img, category = character.category)
                }
            })
        }




    }


}