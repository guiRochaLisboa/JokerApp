package com.example.jokerapp.presentetaion


import android.graphics.Color
import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.data.ListCategoryCallback
import com.example.jokerapp.model.Category
import com.example.jokerapp.ui.HomeFragment

class HomePresenter(private val view: HomeFragment, private val dataSource: CategoryRemoteDataSource) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }


    override fun onSucess(response: List<String>) {
        val start = 158
        val end = 312
        val dif = (end - start) / response.size
        val categories = response.mapIndexed { index, s ->

            val hsv = floatArrayOf(
                start + (dif * index).toFloat(),//H, matriz
                100.0f,//S, saturacao
                100.0f//V, valor
            )

            Category(s, Color.HSVToColor(hsv).toLong()) }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}