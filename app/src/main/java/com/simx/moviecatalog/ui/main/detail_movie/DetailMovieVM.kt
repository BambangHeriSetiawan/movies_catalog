package com.simx.moviecatalog.ui.main.detail_movie

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.simx.moviecatalog.data.api.ApiRequest
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.data.models.review.Reviews
import com.simx.moviecatalog.data.models.video.Videos

class DetailMovieVM:BaseObservable() {
    @Bindable var loadingVideo = ObservableField<Boolean>()
    @Bindable var loadingReview = ObservableField<Boolean>()
    @Bindable var errorMsg = MutableLiveData<String>()

    @Bindable var movie = MutableLiveData<Movie>()
    @Bindable var reviews = MutableLiveData<List<Reviews>>()
    @Bindable var videos = MutableLiveData<List<Videos>>()


    fun videos(movieId:Int?){
        loadingVideo.set(true)
        ApiRequest.videos(movieId = movieId, page = null, listener = object : ApiRequest.OnVideoListener {
            override fun onSuccess(data: List<Videos>?) {
                videos.postValue(data)
            }

            override fun onFailed(msg: String) {
                errorMsg.postValue(msg)
            }

            override fun onLoad(state: Boolean) {
                loadingVideo.set(state)
            }
        })
        reviews(movieId)
    }
    fun reviews(movieId:Int?){
        loadingReview.set(true)
        ApiRequest.reviews(movieId = movieId, page = null, listener = object : ApiRequest.OnReviewListener {
            override fun onSuccess(data: List<Reviews>?) {
                reviews.postValue(data)
            }

            override fun onFailed(msg: String) {
                errorMsg.postValue(msg)
            }

            override fun onLoad(state: Boolean) {
                loadingReview.set(state)
            }
        })

    }
}