package com.simx.moviecatalog.ui.main.detail_movie

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.data.models.review.Reviews
import com.simx.moviecatalog.data.models.video.Videos

class DetailMovieVM:BaseObservable() {
    @Bindable var loading = ObservableField<Boolean>()
    @Bindable var movie = MutableLiveData<Movie>()
    @Bindable var reviews = MutableLiveData<List<Reviews>>()
    @Bindable var videos = MutableLiveData<List<Videos>>()

}