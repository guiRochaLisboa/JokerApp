package com.example.jokerapp.data

import com.example.jokerapp.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.HTTP
import java.lang.RuntimeException

class JokeRemoteDataSource {
    fun findBy(categoryName: String, callback: JokeCallback) {

        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findBy(categoryName)
            .enqueue(object : Callback<Joke>{
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful){
                        val joke = response.body()
                        callback.onSucess(joke ?: throw RuntimeException("Piada não encontrada"))
                    }else{
                        val erro = response.errorBody()?.toString()
                        callback.onError(erro ?: "Erro desconhecido")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }

            })
    }

    fun findByJokeDay(jokeCallback: JokeCallback){

        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findByJokeDay()
            .enqueue(object : Callback<Joke>{
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful){
                        val joke = response.body()
                        jokeCallback.onSucess(joke ?: throw RuntimeException("Erro desconhecido favor entrar em contato com o time de TI"))
                    }else{
                        val erro = response.errorBody().toString()
                        jokeCallback.onError(erro ?: "Erro desconhecido")
                    }

                    jokeCallback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    jokeCallback.onError(t.message ?: "Erro interno")
                    jokeCallback.onComplete()
                }

            }
             )

    }




}