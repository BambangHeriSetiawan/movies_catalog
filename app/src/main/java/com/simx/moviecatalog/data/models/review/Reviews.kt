package com.simx.moviecatalog.data.models.review

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.simx.moviecatalog.data.models.review.AuthorDetails
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Reviews(

	@field:SerializedName("author_details")
	val authorDetails: AuthorDetails? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable