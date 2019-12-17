package com.breakingbad.network

import com.breakingbad.Model.Character
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL: String = "https://www.breakingbadapi.com/api/"

interface BreakingBadAPI {

    @GET("/api/characters")
    fun getCharacters(): Call<List<Character>>
}