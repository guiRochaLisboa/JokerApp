package com.example.jokerapp.data

import com.example.jokerapp.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey")apiKey: String = HTTPClient.TOKEN_KEY) : Call<List<String>>

    @GET("jokes/random")
    fun findBy(@Query("category")categoryName: String,@Query("apiKey") apiKey: String = HTTPClient.TOKEN_KEY) : Call<Joke>

    @GET("jokes/random")
    fun findByJokeDay(@Query("apiKey") apiKey: String = HTTPClient.TOKEN_KEY) : Call<Joke>

}