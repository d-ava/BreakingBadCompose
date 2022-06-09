package com.example.breakingbadcompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {

    val list = listOf<String>(
        "Walter White",
        "name2",
        "name3",
        "name4",
        "name5",
        "name6",
        "name7",
        "name8",
        "name9",
        "name2",
        "name3",
        "name4",
        "name5"
    )

    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(list) { name ->
//            BreakingBadCharacter(title = name)
            BreakingBadCharacterCard(title = name)
        }
    })


}