package com.simx.moviecatalog.components.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.models.review.Reviews
import com.simx.moviecatalog.databinding.ItemReviewBinding

class AdapterReviews ( var datas:List<Reviews>?, var listener:OnAdapterReviewListener): RecyclerView.Adapter<AdapterReviews.Holder>() {
    interface OnAdapterReviewListener {
        fun onClick( data:Reviews?)
    }

    class Holder(var binding: ItemReviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Reviews?){
            with(binding){
                itemReviewVm = ItemReviewVM(data)
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemReviewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data = datas?.get(position))
        holder.itemView.setOnClickListener { listener.onClick(data = datas?.get(position)) }
    }

    override fun getItemCount(): Int {
        return datas?.size!!
    }
}