package com.example.jokerapp.data

interface ListCategoryCallback{

    fun onSucess(response: List<String>)

    fun onError(response: String)

    fun onComplete()
}