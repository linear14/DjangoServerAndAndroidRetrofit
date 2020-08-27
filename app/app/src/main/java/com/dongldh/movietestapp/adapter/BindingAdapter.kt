package com.dongldh.movietestapp.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("movieId")
fun bindIdToString(view: TextView, id: Int) {
    view.text = id.toString()
}

@BindingAdapter("movieYear")
fun bindYearToString(view: TextView, year: Int) {
    view.text = year.toString()
}