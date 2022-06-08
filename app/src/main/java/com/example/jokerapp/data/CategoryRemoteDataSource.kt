package com.example.jokerapp.data

import android.os.Handler
import android.os.Looper

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4"
            )
            callback.onSucess(response)

            callback.onComplete()
        }, 4000)
    }
}