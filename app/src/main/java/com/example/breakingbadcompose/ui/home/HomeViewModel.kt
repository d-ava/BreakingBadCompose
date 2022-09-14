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
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val api: BBCharactersApi,
    private val quotesApi: BBQuotesApi

) : ViewModel() {

    val charactersLoading = mutableStateOf(false)

    val characters: MutableState<List<BBCharacter>> = mutableStateOf(listOf())

    init {
        getBBCharacters()
        getQuotes()
    }

    private fun getBBCharacters() {
        viewModelScope.launch {
            charactersLoading.value = true

            val response = api.getBBCharacters()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                characters.value = body
            }


            charactersLoading.value = false
        }
    }


    var character by mutableStateOf<BBCharacter?>(null)
        private set

    fun addCharacter(newCharacter: BBCharacter) {
        character = newCharacter
    }


    var quotesLoading = mutableStateOf(false)
    val quotes: MutableState<List<BBQuotes>> = mutableStateOf(listOf())



    private fun getQuotes(){
        viewModelScope.launch {

//            quotesLoading.value=true

            val response = quotesApi.getQuotes()
            val body = response.body()

            if (response.isSuccessful && body != null){
                quotes.value = body
//                d("---", "success, quotes is loading")
            }

//            quotesLoading.value = false
        }

    }



}