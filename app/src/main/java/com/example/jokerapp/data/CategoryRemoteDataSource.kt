package com.example.jokerapp.data

import android.os.Handler
import android.os.Looper
import com.example.jokerapp.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback){
        HTTPClient.retrofit().create(ChuckNorrisAPI::class.java)
            .findAllCategories()
            .enqueue(object : Callback<List<String>>{
                override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                    if(response.isSuccessful){
                        val categories = response.body()
                        callback.onSucess(categories ?: emptyList())
                    }else{
                        val erro = response.errorBody()?.toString()
                        callback.onError(erro ?: "Erro desconhecido")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }

            })
    }
}