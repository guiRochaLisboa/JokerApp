package com.example.jokerapp.presentetaion


import com.example.jokerapp.data.JokeCallback
import com.example.jokerapp.data.JokeRemoteDataSource
import com.example.jokerapp.model.Joke
import com.example.jokerapp.ui.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findBy(categoryName : String){
        view.showProgress()
        dataSource.findBy(categoryName,this)
    }

    override fun onSucess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}