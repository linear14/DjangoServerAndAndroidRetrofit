package com.dongldh.movietestapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.dongldh.movietestapp.adapter.MovieAdapter
import com.dongldh.movietestapp.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {
    private val viewModel: MovieViewModel by viewModel { parametersOf(-1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MovieAdapter()
        recycler.adapter = adapter
        subscribeUi(adapter)

        show_movie_btn.setOnClickListener { viewModel.getMovieListRetrofit() }
        add_movie_btn.setOnClickListener { startActivity(Intent(this, AddMovieActivity::class.java)) }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "onRestart")
        viewModel.initMovieList()
    }

    private fun subscribeUi(adapter: MovieAdapter) {
        viewModel.movieList.observe(this) { result ->
            adapter.submitList(result)
        }
    }
}