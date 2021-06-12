package com.simx.moviecatalog.components.video

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simx.moviecatalog.R
import com.simx.moviecatalog.data.models.video.Videos
import com.simx.moviecatalog.databinding.ItemReviewBinding
import com.simx.moviecatalog.databinding.ItemVideoBinding

class AdapterVideos (var datas:List<Videos>?, var listener:OnAdapterVideosListener): RecyclerView.Adapter<AdapterVideos.Holder>() {
    interface OnAdapterVideosListener {
        fun onClick( data:Videos?)
    }

    class Holder(var binding: ItemVideoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Videos?){
            with(binding){
                itemVideoVm = ItemVideoVM(data)
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemVideoBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)))
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data = datas?.get(position))
        holder.binding.imgVideo.settings.apply {
            this.javaScriptEnabled = true
        }
        datas?.get(position)?.videoUrl()?.let { holder.binding.imgVideo.loadUrl(it) }
        holder.itemView.setOnClickListener { listener.onClick(data = datas?.get(position)) }
    }

    override fun getItemCount(): Int {
        return datas?.size!!
    }
}