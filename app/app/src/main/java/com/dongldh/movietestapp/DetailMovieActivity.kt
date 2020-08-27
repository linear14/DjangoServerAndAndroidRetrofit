package com.dongldh.movietestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.dongldh.movietestapp.databinding.ActivityDetailMovieBinding
import com.dongldh.movietestapp.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailMovieActivity : AppCompatActivity() {
    private var movieId: Int? = null
    private val viewModel: MovieViewModel by viewModel { parametersOf(movieId) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieId = intent.getIntExtra("MOVIE_ID", -1)

        val binding = DataBindingUtil.setContentView<ActivityDetailMovieBinding>(this, R.layout.activity_detail_movie)
        binding.movieViewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.getMovie(movieId!!)
        viewModel.movie.observe(this) { result -> }

        binding.deleteBtn.setOnClickListener {
            viewModel.deleteMovie()
            finish()
        }

        binding.updateBtn.setOnClickListener {
            val intent = Intent(this, UpdateMovieActivity::class.java)
            intent.putExtra("MOVIE_ID", movieId!!)
            intent.putExtra("MOVIE_TITLE", viewModel.movie.value!!.title)
            intent.putExtra("MOVIE_GENRE", viewModel.movie.value!!.genre)
            intent.putExtra("MOVIE_YEAR", viewModel.movie.value!!.year)
            startActivity(intent)
            finish()
        }

        binding.cancelBtn.setOnClickListener { finish() }
    }

}