package com.simx.moviecatalog.components.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.GlobalTools
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.databinding.ItemMovieBinding

class AdapterMovie(var listener: OnAdapterMovieListener): PagingDataAdapter<Movie, AdapterMovie.Holder>(GlobalTools.diffUtilMovie){
    interface OnAdapterMovieListener {
        fun onClick( dat: Movie?)
    }

    class Holder(var binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie?){
            with(binding){
                itemMoveVm = ItemMovieVM(movie)
                executePendingBindings()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemMovieBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { listener.onClick(getItem(position)) }
    }
}