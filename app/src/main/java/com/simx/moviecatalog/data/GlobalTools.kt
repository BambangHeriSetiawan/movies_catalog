package com.simx.moviecatalog.data

import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import coil.ImageLoader
import coil.decode.VideoFrameDecoder
import coil.fetch.VideoFrameFileFetcher
import coil.fetch.VideoFrameUriFetcher
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.data.models.movie.ResponseMovie
import com.simx.moviecatalog.data.models.movie.ResponseMovies
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

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

    private const val DATE_PATTERN_TO_HUMAN = "MMM d, yyyy"
    private const val DATE_PATTERN_TO_DEFAULT = "yyyy-MM-dd"

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun dateToString(value:String?): String? {
        val sdf0 = SimpleDateFormat(DATE_PATTERN_TO_DEFAULT, Locale.ENGLISH)
        val sdf1 = SimpleDateFormat(DATE_PATTERN_TO_HUMAN, Locale.ENGLISH)
        if (!value.isNullOrEmpty()){
            return try {
                sdf1.format(sdf0.parse(value).time)
            }catch (e: IOException){
                e.message
            }

        }
        return "--"
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
    fun loadImageRounded(imageView:ImageView, url:String){
        val loader = ImageLoader(imageView.context)
        val req = ImageRequest.Builder(imageView.context)
            .data(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .target(imageView)
        req.transformations(RoundedCornersTransformation(1f))
        loader.enqueue(req.build())
    }
    fun loadImageRounded(imageView:ImageView, url:Int){
        val loader = ImageLoader(imageView.context)
        val req = ImageRequest.Builder(imageView.context)
            .data(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .target(imageView)
        req.transformations(RoundedCornersTransformation(1f))
        loader.enqueue(req.build())
    }
    fun loadVideo(imageView:ImageView, url:String?){
        val loader = ImageLoader.Builder(imageView.context).componentRegistry {
            add(VideoFrameFileFetcher(imageView.context))
            add(VideoFrameUriFetcher(imageView.context))
            add(VideoFrameDecoder(imageView.context))
        }.build()

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