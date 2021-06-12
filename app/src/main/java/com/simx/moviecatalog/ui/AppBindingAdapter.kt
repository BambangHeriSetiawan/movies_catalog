package com.simx.moviecatalog.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.GlobalTools

class AppBindingAdapter {
    companion object {
        @BindingAdapter("bind:image") @JvmStatic fun loadImageUrl(imageView: ImageView, url:String?){
            if (url.isNullOrEmpty())  GlobalTools.loadImage(imageView, R.drawable.ic_baseline_image_24)
            else GlobalTools.loadImage(imageView, url)
        }
        @BindingAdapter("bind:image_rounded") @JvmStatic fun loadImageRounded(imageView: ImageView, url:String?){
            if (url.isNullOrEmpty())  GlobalTools.loadImageRounded(imageView, R.drawable.ic_baseline_image_24)
            else GlobalTools.loadImageRounded(imageView, url)
        }

        @BindingAdapter("bind:image_video") @JvmStatic fun loadVideo(imageView: ImageView, url:String?){
            GlobalTools.loadVideo(imageView = imageView, url = url)
        }

    }
}