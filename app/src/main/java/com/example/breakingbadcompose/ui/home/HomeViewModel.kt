package com.example.breakingbadcompose.ui.home

import android.util.Log.d
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadcompose.api.BBCharactersApi
import com.example.breakingbadcompose.api.BBQuotesApi
import com.example.breakingbadcompose.model.BBCharacter
import com.example.breakingbadcompose.model.BBQuotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val api: BBCharactersApi,
    private val quotesApi: BBQuotesApi

) : ViewModel() {
    //--------------------------
    //test list

//    var testList = mutableListOf<Int>(
//        18760001,
//        2319991,
//        99022837,
//        990100,
//        990220110,
//        9940493,
//        738210092,
//        663738292,
//        99999999,
//        8000000
//    )
//        private set
//
//    fun addNumberToTestList(num: Int) {
//        testList.add(num)
//    }


    //----------------------------
    //add to favourite
    var favouriteList = mutableListOf<Int>()
        private set

    fun addToFavouriteList(id: Int) {
        favouriteList.add(id)
    }

    fun removeFromFavouriteList(id: Int) {
        favouriteList.remove(id)
    }


    //-------------------------------

    val charactersLoading = mutableStateOf(false)
    val charactersMessage = mutableStateOf("")

    val characters: MutableState<List<BBCharacter>> = mutableStateOf(listOf())

    init {
        getBBCharacters()
        getQuotes()
    }

    private fun getBBCharacters() {
        viewModelScope.launch {
            try {
                charactersLoading.value = true
//                delay(2000)

                val response = api.getBBCharacters()
                val body = response.body()
                if (response.isSuccessful && body != null) {
//                    charactersMessage.value = "SUCCESS"
                    characters.value = body
                }else{
                    charactersMessage.value = "unknown error"
                }


                charactersLoading.value = false
            }catch (e: IOException){
                charactersMessage.value = e.message ?: "unknown error"
            }

        }
    }


    var character by mutableStateOf<BBCharacter?>(null)
        private set

    fun addCharacter(newCharacter: BBCharacter) {
        character = newCharacter
    }


    var quotesLoading = mutableStateOf(false)
    val quotes: MutableState<List<BBQuotes>> = mutableStateOf(listOf())


    private fun getQuotes() {
        viewModelScope.launch {

//            quotesLoading.value=true

            val response = quotesApi.getQuotes()
            val body = response.body()

            if (response.isSuccessful && body != null) {
                quotes.value = body
//                d("---", "success, quotes is loading")
            }

//            quotesLoading.value = false
        }

    }


}