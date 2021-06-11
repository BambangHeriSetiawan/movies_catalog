package com.simx.moviecatalog.data.api

import com.simx.moviecatalog.data.models.movie.ResponseMovie
import com.simx.moviecatalog.data.models.movie.ResponseMovies
import com.simx.moviecatalog.data.models.review.ResponseReviews
import com.simx.moviecatalog.data.models.video.ResponseVideos
import retrofit2.Response
import retrofit2.http.*

interface ApiMovie {
    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("movie/{type}")
    suspend fun moviesAsync(
        @Path("type")type:String?,
        @Query("api_key")apiKey:String?,
        @Query("page") page:Int?
    ): Response<ResponseMovies>

    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("movie/{id}")
    suspend fun moviesDetailAsync(
        @Query("api_key")apiKey:String?,
        @Path("id")type:Int?,
    ): Response<ResponseMovie>

    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("movie/{id}/reviews")
    suspend fun moviesReviewAsync(
        @Query("api_key")apiKey:String?,
        @Path("id")type:Int?,
        @Query("page") page:Int?
    ): Response<ResponseReviews>

    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("movie/{id}/videos")
    suspend fun moviesVideosAsync(
        @Query("api_key")apiKey:String?,
        @Path("id")type:Int?,
        @Query("page") page:Int?
    ): Response<ResponseVideos>

    object Factory {
        fun create(): ApiMovie {
            return ApiCore.retrofitConfig("https://api.themoviedb.org/3/").create(ApiMovie::class.java)
        }
    }
}