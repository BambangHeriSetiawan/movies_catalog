package com.simx.moviecatalog.data.models.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ResponseMovie(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
	val totalPages: Int? = null,

    @field:SerializedName("results")
	val results: Movie? = null,

    @field:SerializedName("total_results")
	val totalResults: Int? = null
) : Parcelable