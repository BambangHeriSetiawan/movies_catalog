package com.simx.moviecatalog.data.models.review

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.simx.moviecatalog.data.GlobalTools
import kotlinx.parcelize.Parcelize


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
) : Parcelable {
	fun avatar():String {
		return if (authorDetails?.avatarPath?.contains("https", true)!!) authorDetails.avatarPath
		else GlobalTools.image200(authorDetails.avatarPath)
	}
	fun rate():String {
		return authorDetails?.rating?.toString() ?: "-"
	}
	fun content():String{
		return if (content?.length!! >= 250) "${content.take(250)}... read more"
		else content
	}
}