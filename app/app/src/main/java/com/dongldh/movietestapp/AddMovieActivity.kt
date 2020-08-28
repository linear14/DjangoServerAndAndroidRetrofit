package com.dongldh.movietestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dongldh.movietestapp.data.Movie
import com.dongldh.movietestapp.data.MovieRequest
import com.dongldh.movietestapp.retrofit.MovieRetrofitClient
import com.dongldh.movietestapp.retrofit.MovieRetrofitService
import com.dongldh.movietestapp.util.Util
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        next_btn.setOnClickListener {

            if(movie_title.text.isNullOrEmpty()) {
                Toast.makeText(this, "제목을 입력하세요.", Toast.LENGTH_SHORT).show()
            } else if(movie_genre.text.isNullOrEmpty()) {
                Toast.makeText(this, "장르를 입력하세요.", Toast.LENGTH_SHORT).show()
            } else if(movie_year.text.isNullOrEmpty()) {
                Toast.makeText(this, "연도를 입력하세요.", Toast.LENGTH_SHORT).show()
            } else if(!Util.isYearNumber(movie_year.text.toString())) {
                Toast.makeText(this, "연도는 숫자를 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                MovieRetrofitClient.addMovie(
                    MovieRequest(
                        movie_title.text.toString(),
                        movie_genre.text.toString(),
                        movie_year.text.toString().toInt()
                    )
                )
                finish()
            }
        }

        cancel_btn.setOnClickListener { finish() }
    }
}