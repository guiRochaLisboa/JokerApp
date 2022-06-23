package com.example.jokerapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey")apiKey: String = HTTPClient.TOKEN_KEY) : Call<List<String>>
}