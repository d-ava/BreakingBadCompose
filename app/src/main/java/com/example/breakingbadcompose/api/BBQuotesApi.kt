package com.example.breakingbadcompose.api

import com.example.breakingbadcompose.model.BBQuotes
import retrofit2.Response
import retrofit2.http.GET

interface BBQuotesApi {


    @GET("quotes")
    suspend fun getQuotes():Response<List<BBQuotes>>
}