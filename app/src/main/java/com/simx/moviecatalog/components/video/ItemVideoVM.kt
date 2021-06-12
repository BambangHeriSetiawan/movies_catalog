package com.simx.moviecatalog.components.video

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.simx.moviecatalog.data.models.video.Videos

class ItemVideoVM (video:Videos?):BaseObservable() {
    @Bindable var video = ObservableField<String>(video?.videoUrl())
}