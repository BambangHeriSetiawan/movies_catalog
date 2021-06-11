package com.simx.moviecatalog.components.movie

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.simx.moviecatalog.data.GlobalTools
import com.simx.moviecatalog.data.models.movie.Movie

class ItemMovieVM( movie: Movie?):BaseObservable() {
    @Bindable var image = ObservableField<String>(GlobalTools.image300(movie?.posterPath))
    @Bindable var title = ObservableField<String>(movie?.title)
    @Bindable var releaseDate = ObservableField<String>(movie?.releaseDate)
    @Bindable var rate = ObservableField<String>(movie?.voteAverage.toString())
}