package com.example.jokerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.jokerapp.R
import com.example.jokerapp.databinding.FragmentJokerDayBinding

class JokerDayFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_joker_day, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}