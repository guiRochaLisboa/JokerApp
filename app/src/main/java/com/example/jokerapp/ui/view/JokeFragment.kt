package com.example.jokerapp.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.jokerapp.R
import com.example.jokerapp.model.Joke
import com.example.jokerapp.presentetaion.HomePresenter
import com.example.jokerapp.presentetaion.JokePresenter

class JokeFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    private lateinit var mPrenseter: JokePresenter



    companion object {
        const val CATEGORY_KEY = "category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPrenseter = JokePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_joker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString(CATEGORY_KEY)!!

        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryName
        progressBar = view.findViewById(R.id.progress_bar)
        textView = view.findViewById(R.id.txt_joke)


        mPrenseter.findBy(categoryName)
    }

    fun showJoke(joke : Joke){
        textView.text = joke.text
        //TODO : adicionar a imagem
    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }


}