package com.simx.moviecatalog.ui.main

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.simx.moviecatalog.data.models.movie.Movie
import com.simx.moviecatalog.data.source.MovieDataSource
import kotlinx.coroutines.flow.Flow

class MainVm: BaseObservable() {
    @Bindable var loading = ObservableField<Boolean>()
    @Bindable var empty = ObservableField<Boolean>()
    @Bindable var errorMsg = MutableLiveData<String>()

    fun movies( path:String):Flow<PagingData<Movie>> {
        val config = PagingConfig( pageSize = 30, enablePlaceholders = true)
        val pagingFactory = { MovieDataSource(path = path) }
        return Pager( config = config, pagingSourceFactory = pagingFactory).flow
    }
}