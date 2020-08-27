package com.dongldh.movietestapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dongldh.movietestapp.DetailMovieActivity
import com.dongldh.movietestapp.data.Movie
import com.dongldh.movietestapp.databinding.ItemMovieBinding

class MovieAdapter() : ListAdapter<Movie, RecyclerView.ViewHolder>(MovieDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = getItem(position)
        (holder as MovieViewHolder).bind(movie)
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            binding.apply {
                movie = item
                setClickListener {
                    val context = binding.root.context
                    val intent = Intent(context, DetailMovieActivity::class.java)
                    intent.putExtra("MOVIE_ID", item.id)
                    context.startActivity(intent)
                }

                executePendingBindings()
            }
        }
    }


}

private class MovieDiffCallback: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}
