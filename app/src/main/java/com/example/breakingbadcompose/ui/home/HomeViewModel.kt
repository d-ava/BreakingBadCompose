package com.example.breakingbadcompose.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadcompose.api.BBCharactersApi
import com.example.breakingbadcompose.model.BBCharacter
import com.example.breakingbadcompose.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
    private val api: BBCharactersApi,
//    private val repository: CharactersRepository
):ViewModel() {

    val characters: MutableState<List<BBCharacter>> = mutableStateOf(listOf())

    init {
test()
    }

private fun test(){
    viewModelScope.launch {
        val response = api.getBBCharacters()
        val body = response.body()
        if (response.isSuccessful && body != null){
            characters.value = body
        }
    }
}

}