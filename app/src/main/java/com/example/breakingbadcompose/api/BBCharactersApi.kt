package com.example.breakingbadcompose.api

import com.example.breakingbadcompose.model.BBCharacter
import retrofit2.Response
import retrofit2.http.GET

interface BBCharactersApi {

    @GET("characters")
    suspend fun getBBCharacters():Response<List<BBCharacter>>


}