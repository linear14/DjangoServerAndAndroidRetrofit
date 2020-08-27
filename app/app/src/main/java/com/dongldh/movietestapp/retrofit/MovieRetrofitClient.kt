package com.dongldh.movietestapp.retrofit

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.dongldh.movietestapp.app.MyApplication
import com.dongldh.movietestapp.data.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRetrofitClient {

    fun getMovieList(movieList: MutableLiveData<List<Movie>>) {
        MovieRetrofit.getService().getMovieList().enqueue(object: Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Log.d("RETROFIT_RESULT", "getMovieList: onFailure")
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if(response.isSuccessful) {
                    Log.d("RETROFIT_RESULT", "getMovieList: onResponse")
                    movieList.value = response.body()
                } else {
                    Log.d("RETROFIT_RESULT", "getMovieList: onResponse but get responses fail ")
                }
            }

        })
    }

    fun getMovie(movie: MutableLiveData<Movie>, id: Int) {
        MovieRetrofit.getService().getMovie(id).enqueue(object: Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    movie.value = response.body()
                }
            }

        })
    }

    fun addMovie(movie: Movie) {
        MovieRetrofit.getService().addMovie(movie).enqueue(object: Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d("RETROFIT_RESULT", "addMovie: onFailure")
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    Log.d("RETROFIT_RESULT", "addMovie: onResponse")
                    Toast.makeText(MyApplication.applicationContext(), "영화 등록 완료", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("RETROFIT_RESULT", "addMovie: onResponse but get responses fail ")
                }
            }

        })
    }

    fun updateMovie(movie: Movie) {
        MovieRetrofit.getService().updateMovie(movie.id, movie).enqueue(object: Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
            }
        })

    }

    fun deleteMovie(id: Int) {
        MovieRetrofit.getService().deleteMovie(id).enqueue(object: Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    Toast.makeText(MyApplication.applicationContext(), "영화 삭제 완료", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(MyApplication.applicationContext(), "뭔가 잘못됨", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}