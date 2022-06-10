package com.example.breakingbadcompose.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.breakingbadcompose.ui.BreakingBadCharacterCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(charactersViewModel:HomeViewModel = viewModel()) {

//    val list = listOf<String>(
//        "Walter White",
//        "name2",
//        "name3",
//        "name4",
//        "name5",
//        "name6",
//        "name7",
//        "name8",
//        "name9",
//        "name2",
//        "name3",
//        "name4",
//        "name5"
//    )

    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(charactersViewModel.characters.value) { character ->
//            BreakingBadCharacter(title = name)
            BreakingBadCharacterCard(title = character.name, img = character.img)
        }
    })


}