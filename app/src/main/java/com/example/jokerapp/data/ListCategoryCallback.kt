package com.example.jokerapp.data

import java.net.CacheResponse

interface ListCategoryCallback{

    fun onSucess(response: List<String>)

    fun onError(response: String)

    fun onComplete()
}