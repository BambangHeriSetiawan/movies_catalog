package com.simx.moviecatalog.data

import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import coil.ImageLoader
import coil.request.ImageRequest
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.data.models.movie.ResponseMovie
import com.simx.moviecatalog.data.models.movie.ResponseMovies

object GlobalTools {
    fun youtubeUrl(key:String?):String {
        return "https://www.youtube.com/embed/$key"
    }
    fun image200(path:String?): String {
        return "https://image.tmdb.org/t/p/w200$path"
    }
    fun image300(path:String?): String {
        return "https://image.tmdb.org/t/p/w300$path"
    }
    fun image400(path:String?): String {
        return "https://image.tmdb.org/t/p/w400$path"
    }
    fun image500(path:String?): String {
        return "https://image.tmdb.org/t/p/w500$path"
    }

    fun loadImage(imageView:ImageView, url:String){
        val loader = ImageLoader(imageView.context)
        val req = ImageRequest.Builder(imageView.context)
            .data(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .target(imageView)
        loader.enqueue(req.build())
    }
    fun loadImage(imageView:ImageView, url:Int){
        val loader = ImageLoader(imageView.context)
        val req = ImageRequest.Builder(imageView.context)
            .data(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .target(imageView)
        loader.enqueue(req.build())
    }
    val diffUtilMovie = object : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}