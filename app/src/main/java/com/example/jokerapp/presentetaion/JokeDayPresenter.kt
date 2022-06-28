package com.example.jokerapp.presentetaion

import com.example.jokerapp.data.JokeCallback
import com.example.jokerapp.data.JokeRemoteDataSource
import com.example.jokerapp.model.Joke
import com.example.jokerapp.ui.JokerDayFragment

class JokeDayPresenter(
    private val view: JokerDayFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findByJokeDay(){
        view.showProgress()
        dataSource.findByJokeDay(this)
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