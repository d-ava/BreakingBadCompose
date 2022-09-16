package com.example.breakingbadcompose.ui.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.breakingbadcompose.R
import com.example.breakingbadcompose.ui.BreakingBadCharacterCard
import com.example.breakingbadcompose.ui.home.HomeViewModel
import com.example.breakingbadcompose.ui.theme.bbFonts
import com.example.breakingbadcompose.ui.theme.bb_background
import com.example.breakingbadcompose.ui.theme.bb_control_color
import com.example.breakingbadcompose.ui.theme.bb_white
import com.example.breakingbadcompose.util.Graph


@Composable
fun SearchScreen(
    vm: HomeViewModel, navController: NavHostController

) {


    val searchTextState = remember { mutableStateOf(TextFieldValue("")) }



    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_main_logo),
            modifier = Modifier
                .padding(top = 256.dp)
                .alpha(0.5f),
            contentDescription = "main logo"
        )

        Column() {

//            BBSearchField(text = searchTextState)
//
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = androidx.compose.ui.Modifier.padding(top = 8.dp)
            ) {

//                val searchTextState = remember{ mutableStateOf(TextFieldValue())}

                TextField(
                    value = searchTextState.value,
                    onValueChange = {
                        searchTextState.value = it
                    },
                    shape = RoundedCornerShape(16.dp),
                    leadingIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "search icon"
                            )
                        }
                    },
                    singleLine = true,
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                        .height(48.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = bb_white,
                        backgroundColor = bb_control_color,
                        trailingIconColor = Color.Red,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        cursorColor = bb_white,

                        ),
                    textStyle = TextStyle.Default.copy(
                        fontFamily = bbFonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )

                )
//                d("---", "search text = ${searchTextState.value}")
            }


//

            Box(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, bottom = 64.dp)
            ) {

                if (searchTextState.value.text.isNotBlank()) {

                    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                        items(vm.characters.value.filter { searchTextState.value.text.lowercase() in it.name.lowercase() || searchTextState.value.text.lowercase() in it.nickname.lowercase() }) { character ->

                            BreakingBadCharacterCard(
                                title = character.name,
                                img = character.img,
                                category = character.category,
                                onClick = {


                                    navController.navigate(Graph.DETAILS)
                                    vm.addCharacter(character)
                                },


                                favourite = vm.favouriteList.contains(character.charId),
                                txtOnclick = {}
                            )
                        }
                    })

                }


            }


        }

    }


}



