package com.dongldh.movietestapp.retrofit

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.dongldh.movietestapp.app.MyApplication
import com.dongldh.movietestapp.data.Movie
import com.dongldh.movietestapp.data.MovieRequest
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
                Log.d("RETROFIT_RESULT", "getMovie: onFailure")
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    Log.d("RETROFIT_RESULT", "getMovie: onResponse")
                    movie.value = response.body()
                } else {
                    Log.d("RETROFIT_RESULT", "getMovie: onResponse but get responses fail ")
                }
            }

        })
    }

    fun addMovie(movie: MovieRequest) {
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

    fun updateMovie(id: Int, movie: MovieRequest) {
        MovieRetrofit.getService().updateMovie(id, movie).enqueue(object: Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d("RETROFIT_RESULT", "updateMovie: onFailure")
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    Log.d("RETROFIT_RESULT", "updateMovie: onResponse")
                    Toast.makeText(MyApplication.applicationContext(), "정보 수정 완료 : 조회 버튼을 다시 눌러보세요", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("RETROFIT_RESULT", "updateMovie: onResponse but get responses fail ")
                }
            }
        })

    }

    fun deleteMovie(id: Int) {
        MovieRetrofit.getService().deleteMovie(id).enqueue(object: Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d("RETROFIT_RESULT", "deleteMovie: onFailure")
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    Log.d("RETROFIT_RESULT", "deleteMovie: onResponse")
                    Toast.makeText(MyApplication.applicationContext(), "영화 삭제 완료 : 조회 버튼을 다시 눌러보세요", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("RETROFIT_RESULT", "deleteMovie: onResponse but get responses fail ")
                }
            }
        })
    }
}