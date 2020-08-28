package com.dongldh.movietestapp.data

data class Movie(
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int
) {

}

data class MovieRequest(
    val title: String,
    val genre: String,
    val year: Int
) {

}