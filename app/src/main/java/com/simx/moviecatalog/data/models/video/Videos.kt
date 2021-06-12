package com.simx.moviecatalog.data.models.video

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Videos(
    @field:SerializedName("site")
    val site: String? = null,

    @field:SerializedName("size")
    val size: Int? = null,

    @field:SerializedName("iso_3166_1")
    val iso31661: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("iso_639_1")
    val iso6391: String? = null,

    @field:SerializedName("key")
    val key: String? = null
) : Parcelable {
    fun videoUrl():String {
        return "https://www.youtube.com/embed/$key"
    }
}
