package com.example.breakingbadcompose.repository

import com.example.breakingbadcompose.api.BBCharactersApi
import com.example.breakingbadcompose.model.BBCharacter
import com.example.breakingbadcompose.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import java.io.IOException

class CharactersRepository @Inject constructor(
    private val charactersApi: BBCharactersApi
){

    fun getCharacters(): Flow<Resource<List<BBCharacter>>>{

        return flow {
            try {
                emit(Resource.Loading())
                val response = charactersApi.getBBCharacters()
                val body = response.body()
                if (response.isSuccessful && body != null){
                    emit(Resource.Success(body))
                }else
                {
                    emit(Resource.Error("unknown error"))
                }
            }catch (e:IOException){
                emit(Resource.Error(e.message ?:"unknown error"))
            }
        }.flowOn(Dispatchers.IO)


    }




}