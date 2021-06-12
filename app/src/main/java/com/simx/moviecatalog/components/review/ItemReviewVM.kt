package com.simx.moviecatalog.components.review

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.simx.moviecatalog.data.models.review.Reviews

class ItemReviewVM(review: Reviews?): BaseObservable() {
    @Bindable var author = ObservableField<String>(review?.author)
    @Bindable var avatar = ObservableField<String>(review?.avatar())
    @Bindable var rating = ObservableField<String>(review?.rate())
    @Bindable var content = ObservableField<String>(review?.content())

}