package com.dongldh.movietestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dongldh.movietestapp.data.Movie
import com.dongldh.movietestapp.retrofit.MovieRetrofitClient
import com.dongldh.movietestapp.retrofit.MovieRetrofitService
import kotlinx.android.synthetic.main.activity_add_movie.*

class UpdateMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        movie_title.setText(intent.getStringExtra("MOVIE_TITLE"))
        movie_genre.setText(intent.getStringExtra("MOVIE_GENRE"))
        movie_year.setText(intent.getIntExtra("MOVIE_YEAR", -1).toString())

        next_btn.text = "수정하기"
        next_btn.setOnClickListener {
            MovieRetrofitClient.updateMovie(
                Movie(
                    intent.getIntExtra("MOVIE_ID", -1),
                    movie_title.text.toString(),
                    movie_genre.text.toString(),
                    movie_year.text.toString().toInt()
                )
            )
            finish()
        }

        cancel_btn.setOnClickListener { finish() }
    }
}