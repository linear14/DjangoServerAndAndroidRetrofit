package com.dongldh.movietestapp.retrofit

import com.dongldh.movietestapp.data.Movie
import retrofit2.Call
import retrofit2.http.*

interface MovieRetrofitService {
    @GET("/movies/")
    fun getMovieList(): Call<List<Movie>>

    @POST("/movies/")
    fun addMovie(
        @Body movie: Movie
    ): Call<Movie>

    @GET("/movies/{id}/")
    fun getMovie(
        @Path("id") id: Int
    ): Call<Movie>

    @PUT("/movies/{id}/")
    fun updateMovie(
        @Path("id") id: Int,
        @Body movie: Movie
    ): Call<Movie>

    @DELETE("/movies/{id}/")
    fun deleteMovie(
        @Path("id") id: Int
    ): Call<Movie>
}