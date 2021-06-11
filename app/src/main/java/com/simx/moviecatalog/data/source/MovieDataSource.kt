package com.simx.moviecatalog.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.simx.moviecatalog.data.api.ApiMovie
import com.simx.moviecatalog.data.models.movie.Movie

class MovieDataSource(var path:String?): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val currentLoadingPageKey = params.key ?: 1
        val res = ApiMovie.Factory.create().moviesAsync(path, "8bd5fd5cf00be94f16916661aac61163", currentLoadingPageKey)
        val data = res.body()?.results ?: emptyList()
        val currentPage = res.body()?.page
        val nextKey  = if (data.isNullOrEmpty()) null else currentPage?.plus(1)
        val prevKey = if (currentPage == 1) null else currentPage?.minus(1)
        return LoadResult.Page(data = data, prevKey =  prevKey, nextKey = nextKey)
    }
}