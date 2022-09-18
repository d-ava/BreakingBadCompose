package com.example.breakingbadcompose.ui.home

import android.annotation.SuppressLint
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
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.BreakingBadCharacterCard
import com.example.breakingbadcompose.ui.theme.*
import com.example.breakingbadcompose.ui.uiComponents.BBProgressIndicator
import com.example.breakingbadcompose.util.Graph
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(


    vm: HomeViewModel,
    navController: NavHostController

) {

//    val test = vm.quotes.value
//    d("---", "quotes - $test")


    val scaffoldState = rememberScaffoldState()
    val c = rememberCoroutineScope()


    val loading = vm.charactersLoading.value
    Column(modifier = Modifier.background(bb_control_color)) {

        Text(

            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold,

            text = stringResource(id = R.string.all_characters),
            color = bb_white,
            fontFamily = bbFonts,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)

        )

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(bottom = 64.dp)
//            ) {

        Scaffold(
            scaffoldState = scaffoldState,
            modifier = Modifier
                .background(bb_background)
                .padding(bottom = 64.dp).alpha(1f)
        ) {


            LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.background(
                bb_background
            ), content = {
                items(vm.characters.value) { character ->

                    BreakingBadCharacterCard(
                        title = character.name,
                        portrayed = character.portrayed,
                        img = character.img,
                        category = character.category,
                        onClick = {

//                            navController.currentBackStackEntry?.savedStateHandle?.set(
//                                "bb_character",
//                                character
//                            )
                            navController.navigate(Graph.DETAILS)
                            vm.addCharacter(character)
                        },

                        favourite = vm.favouriteList.contains(character.charId),
                        txtOnclick = {
                            c.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    "Char ID ${character.charId}",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    )
                }
            })

            BBProgressIndicator(show = loading)
        }

    }


//        }

}





