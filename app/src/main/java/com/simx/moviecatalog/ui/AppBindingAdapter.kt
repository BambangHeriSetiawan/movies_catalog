package com.simx.moviecatalog.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.GlobalTools

class AppBindingAdapter {
    companion object {
        @BindingAdapter("bind:image") @JvmStatic fun loadImageUrl(imageView: ImageView, url:String?){
            if (url.isNullOrEmpty())  GlobalTools.loadImage(imageView, R.drawable.ic_launcher_background)
            else GlobalTools.loadImage(imageView, url, )
        }

    }
}