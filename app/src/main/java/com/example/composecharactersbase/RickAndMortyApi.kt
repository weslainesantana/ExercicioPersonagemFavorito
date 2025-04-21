package com.example.composecharactersbase

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    fun getCharacters(@Query("page") page: Int = 1): Call<ApiResponse>
}