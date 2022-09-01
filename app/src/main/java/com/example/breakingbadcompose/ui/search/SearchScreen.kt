package com.example.breakingbadcompose.ui.search

import android.util.Log.d
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import com.example.breakingbadcompose.ui.login.BBTextField
import com.example.breakingbadcompose.ui.theme.*
import com.example.breakingbadcompose.ui.uiComponents.BBProgressIndicator
import com.example.breakingbadcompose.ui.uiComponents.BBSearchField
import com.example.breakingbadcompose.util.Graph
import java.lang.reflect.Modifier
import java.nio.file.Files.size

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    vm: HomeViewModel ,navController:NavHostController

) {


    val searchTextState = remember { mutableStateOf(TextFieldValue("")) }



    Box(
        modifier = androidx.compose.ui.Modifier
            .background(color = bb_background)
            .fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {

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

                    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
                        items(vm.characters.value.filter { searchTextState.value.text.lowercase() in it.name.lowercase() || searchTextState.value.text.lowercase() in it.nickname.lowercase() }) { character ->

                            BreakingBadCharacterCard(
                                title = character.name,
                                img = character.img,
                                category = character.category,
                                onClick = {


                                navController.navigate(Graph.DETAILS)
                                vm.addCharacter(character)
                                })
                        }
                    })

                }


            }


        }

    }


}

//@Composable
//@Preview(showBackground = true)
//fun SearchScreenPreview(){
//    SearchScreen()
//}

