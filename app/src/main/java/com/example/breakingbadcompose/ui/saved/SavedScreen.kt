package com.example.breakingbadcompose.ui.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.breakingbadcompose.ui.BreakingBadCharacterCard
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.theme.*
import com.example.breakingbadcompose.util.Graph

@Composable
fun SavedScreen(vm: HomeViewModel, navController: NavHostController) {


    val searchTextState = remember { mutableStateOf(TextFieldValue("")) }
    val list = vm.favouriteList



    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {

        Column() {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, bottom = 64.dp)
            ) {


                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                    items(vm.characters.value.filter { list.contains(it.charId) }) { character ->

                        BreakingBadCharacterCard(
                            title = character.name,
                            img = character.img,
                            category = character.category,
                            onClick = {


                                navController.navigate(Graph.DETAILS)
                                vm.addCharacter(character)
                            },


                            favourite = vm.favouriteList.contains(character.charId))
                    }
                })


            }


        }

    }


}

