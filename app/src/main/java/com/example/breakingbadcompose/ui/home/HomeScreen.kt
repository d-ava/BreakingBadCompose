package com.example.breakingbadcompose.ui.home

import android.util.Log.d
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.breakingbadcompose.ui.BreakingBadCharacterCard
import com.example.breakingbadcompose.ui.theme.bbFonts
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.theme.bb_white
import com.example.breakingbadcompose.ui.uiComponents.BBProgressIndicator
import com.example.breakingbadcompose.util.Graph

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(

    vm: HomeViewModel,
    navController: NavHostController

) {

//    val test = vm.quotes.value
//    d("---", "quotes - $test")




    Box(
        modifier = Modifier
            .background(color = bb_background)
            .fillMaxSize(), //contentAlignment = Alignment.Center

    ) {

        val loading = vm.charactersLoading.value
        Column() {

            Text(

                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,

                text = "Characters",
                color = bb_white,
                fontFamily = bbFonts
                ,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)

            )

            Box(modifier = Modifier.fillMaxSize().padding(bottom = 64.dp)) {




                LazyVerticalGrid(GridCells.Fixed(2), content = {
                    items(vm.characters.value) { character ->

                        BreakingBadCharacterCard(
                            title = character.name,
                            img = character.img,
                            category = character.category,
                            onClick = {

//                            navController.currentBackStackEntry?.savedStateHandle?.set(
//                                "bb_character",
//                                character
//                            )
                                navController.navigate(Graph.DETAILS)
                                vm.addCharacter(character)
                            })
                    }
                })

                BBProgressIndicator(show = loading)

            }

        }


    }


}