package com.simx.moviecatalog.data.api

import android.util.Log
import com.simx.moviecatalog.BuildConfig
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.data.models.review.Reviews
import com.simx.moviecatalog.data.models.video.Videos
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.HttpException

object ApiRequest {
    private var job = SupervisorJob()

    interface OnMoviesListener {
        fun onSuccess(data:List<Movie>?)
        fun onFailed(msg:String)
        fun onLoad(state:Boolean)
    }

    fun movies(path:String?, page:Int,  listener: OnMoviesListener ){
        listener.onLoad(true)
        try {
            CoroutineScope(CoroutineExceptionHandler { _, throwable ->
                job = SupervisorJob()
                listener.onFailed(throwable.toString())
                listener.onLoad(false)
            }).launch {
                ApiMovie.Factory.create().moviesAsync(BuildConfig.API_KEY, path, page).let { response ->
                    listener.onLoad(false)
                    if (response.isSuccessful){
                        listener.onSuccess(response.body()?.results)
                    } else {
                        listener.onFailed(response.message())
                    }
                }
            }
        }catch (e:HttpException){
            listener.onLoad(false)
            listener.onFailed(e.message())
        }
    }

    interface OnReviewListener {
        fun onSuccess(data:List<Reviews>?)
        fun onFailed(msg:String)
        fun onLoad(state:Boolean)
    }

    fun reviews(movieId:Int?, listener: OnReviewListener){
        listener.onLoad(true)
        try {
            CoroutineScope(CoroutineExceptionHandler { _, throwable ->
                job = SupervisorJob()
                listener.onFailed(throwable.toString())
                listener.onLoad(false)
            }).launch {
                ApiMovie.Factory.create().moviesReviewAsync( movieId,BuildConfig.API_KEY).let { response ->
                    listener.onLoad(false)
                    if (response.isSuccessful){
                        listener.onSuccess(response.body()?.results)
                    } else {
                        listener.onFailed(response.message())
                    }
                }
            }
        }catch (e:HttpException){
            listener.onLoad(false)
            listener.onFailed(e.message())
        }
    }

    interface OnVideoListener {
        fun onSuccess(data:List<Videos>?)
        fun onFailed(msg:String)
        fun onLoad(state:Boolean)
    }
    fun videos(movieId:Int?, listener: OnVideoListener){
        listener.onLoad(true)
        try {
            CoroutineScope(CoroutineExceptionHandler { _, throwable ->
                job = SupervisorJob()
                listener.onFailed(throwable.toString())
                listener.onLoad(false)
            }).launch {
                ApiMovie.Factory.create().moviesVideosAsync(movieId, BuildConfig.API_KEY).let { response ->
                    listener.onLoad(false)
                    Log.v("DetailMovieActivity","videos response -> ${response.body()}")
                    if (response.isSuccessful){
                        listener.onSuccess(response.body()?.results)
                    } else {
                        listener.onFailed(response.message())
                    }
                }
            }
        }catch (e:HttpException){
            listener.onLoad(false)
            listener.onFailed(e.message())
        }
    }
}