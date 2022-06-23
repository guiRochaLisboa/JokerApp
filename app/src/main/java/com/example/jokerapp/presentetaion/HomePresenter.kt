package com.example.jokerapp.presentetaion


import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.data.ListCategoryCallback
import com.example.jokerapp.model.Category
import com.example.jokerapp.ui.HomeFragment

class HomePresenter(private val view: HomeFragment,private val dataSource: CategoryRemoteDataSource) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }


    override fun onSucess(response: List<String>) {
        val categories = response.map { Category(it,0xFFFF0000) }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}