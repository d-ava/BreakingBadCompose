package com.example.breakingbadcompose.ui.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breakingbadcompose.ui.BreakingBadCharacterCard
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.login.BBTextField
import com.example.breakingbadcompose.ui.theme.bb_active_color
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.uiComponents.BBProgressIndicator
import com.example.breakingbadcompose.util.Graph
import java.lang.reflect.Modifier
import java.nio.file.Files.size

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    vm: HomeViewModel

) {

    val loading = vm.charactersLoading.value

    val searchTextState = remember { mutableStateOf("") }

    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {

        Column() {

            BBTextField(text = searchTextState, title = "search")

            Box(modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(top = 8.dp)) {


                LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
                    items(vm.characters.value) { character ->

                        BreakingBadCharacterCard(
                            title = character.name,
                            img = character.img,
                            category = character.category,
                            onClick = {


//                                navController.navigate(Graph.DETAILS)
//                                vm.addCharacter(character)
                            })
                    }
                })

                BBProgressIndicator(show = loading)

            }


        }

    }


}

//@Composable
//@Preview(showBackground = true)
//fun SearchScreenPreview(){
//    SearchScreen()
//}

