package com.dongldh.movietestapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dongldh.movietestapp.data.Movie
import com.dongldh.movietestapp.retrofit.MovieRetrofitClient

class MovieViewModel(id: Int) : ViewModel() {
    var movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    var movie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovieListRetrofit() {
        MovieRetrofitClient.getMovieList(movieList)
    }

    fun getMovie(id: Int) {
        MovieRetrofitClient.getMovie(movie, id)
    }

    fun deleteMovie() {
        MovieRetrofitClient.deleteMovie(movie.value!!.id)
    }
}